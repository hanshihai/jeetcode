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

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++) {
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++) {
                    boolean duplicated = false;
                    int[] temp = new int[] {nums[i],nums[j],nums[k]};
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        Arrays.sort(temp);
                        for(List<Integer> e : result) {
                            if(e.get(0) == temp[0] && e.get(1) == temp[1] && e.get(2) == temp[2]) {
                                duplicated = true;
                            }
                        }
                        if(duplicated) {
                            continue;
                        }
                        List<Integer> lists = new ArrayList<>();
                        for(int ti=0;ti<temp.length;ti++) {
                            lists.add(temp[ti]);
                        }
                        result.add(lists);
                    }
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        if(x == 0) {
            return true;
        }
        StringBuilder buffer = new StringBuilder();
        int newValue = 0;
        try {
            newValue = Integer.valueOf(buffer.append(x).reverse().toString());
        }catch(Exception e) {
            return false;
        }
        return newValue == x;
    }

    public double myPow(double x, int n) {
        if(x == 0 || x == 1) {
            return x;
        }
        if(x == -1) {
            int single = n % 2;
            if(single == 0) {
                return 1;
            }else{
                return x;
            }
        }
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        long maxN = n;
        if(maxN <= Integer.MIN_VALUE || maxN >= Integer.MAX_VALUE) {
            return 0;
        }
        if(n < 0) {
            n = -n;
            x = 1 / x;
        }
        int single = n % 2;
        int sqort = n / 2;
        if(sqort == 1) {
            double result = x * x;
            if(single != 0) {
                return result * x;
            }
            return result;
        }else{
            if(single != 0) {
                return myPow(x*x, sqort) * x;
            }
            return myPow(x*x, sqort);
        }
    }

    public static void main(String[] args) {
        /*Array array = new Array();
        int result = array.removeOneByOne(6);
        System.out.println(result);*/

        int[] threeSum = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println("sum: " + Array.threeSum(threeSum));

       /* int[] a = new int[] {1, 4, 8, 15};
        int[] b = new int[] {2, 3, 5, 6, 14};
        int[] r = Array.merge(a, b);
        Arrays.stream(r).forEach(k -> System.out.print(k + " "));
        System.out.println("media :" + Array.median(r));*/
    }
}
