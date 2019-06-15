package jeet.code;

import java.util.*;

public class Array {

    public static int[] merge(int[] nums1, int[] nums2) {
        int[] together = new int[nums1.length + nums2.length];
        int i=0;
        int j=0;
        for(int k=0;k<together.length;k++) {
            if(i == nums1.length) {
                together[k] = nums2[j];
                j++;
                continue;
            }
            if(j == nums2.length) {
                together[k] = nums1[i];
                i++;
                continue;
            }
            if(nums1[i] <= nums2[j]) {
                together[k] = nums1[i];
                i++;
            }else{
                together[k] = nums2[j];
                j++;
            }
        }
        return together;
    }

    public static double median(int[] a) {
        int len = a.length;
        if(len % 2 == 0) {
            int index = len / 2;
            return (a[index] + a[index - 1]) / 2d;
        }else{
            int index = len / 2;
            return a[index];
        }
    }

    public int removeDuplicates(int[] nums) {
        int keep = 0;
        int current = 1;
        int length = nums.length;
        while(current < length){
            if(nums[current] == nums[keep]) {
                for(int i = current; i < nums.length - 1; i++) {
                    nums[i] = nums[i+1];
                }
                length--;
            }else{
                current++;
                keep++;
            }
        }
        return keep + 1;
    }

    public int[] rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            int newLocation = (i + k) % nums.length;
            temp[newLocation] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, temp.length);
        return temp;
    }

    public boolean containsDuplicate(int[] nums) {
        /*long count = Arrays.stream(nums).distinct().count();
        return count != nums.length;*/

        Set<Integer> buffer = new HashSet<Integer>();
        for(int i: nums) {
            boolean result = buffer.add(i);
            if(!result) {
                return true;
            }
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int result = 0;
        boolean got = false;
        boolean flag = true;
        for(int i=1;i<nums.length;i++) {
            if((nums[i-1] == nums[i]) == flag) {
                flag = !flag;
            }else{
                if(flag) {
                    result = nums[i-1];
                }else{
                    result = nums[i];
                }
                got = true;
                break;
            }
        }
        if(!got) {
            return nums[nums.length-1];
        }
        return result;
    }

    public int[] moveZeroes(int[] nums) {
        int length = nums.length;
        int location = 0;
        while(location < length) {
            if(nums[location] == 0) {
                for(int i=location;i<length-1;i++){
                    nums[i] = nums[i+1];
                }
                nums[length-1] = 0;
                length--;
            }else{
                location++;
            }
        }
        return nums;
    }

    public int removeOneByOne(int length) {
        List<Integer> nums = new ArrayList<>();
        for(int i=1;i<=length;i++){
            nums.add(i);
        }
        while(true) {
            int dead = length-1;
            if(dead >= nums.size()) {
                dead = dead % nums.size();
            }
            nums.remove(dead);
            if(nums.size() == 1) {
                break;
            }
        }
        return nums.get(0);
    }

    public static void main(String[] args) {
        /*Array array = new Array();
        int result = array.removeOneByOne(6);
        System.out.println(result);*/

        int[] a = new int[] {1, 4, 8, 15};
        int[] b = new int[] {2, 3, 5, 6, 14};
        int[] r = Array.merge(a, b);
        Arrays.stream(r).forEach(k -> System.out.print(k + " "));
        System.out.println("media :" + Array.median(r));
    }
}
