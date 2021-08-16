package jeet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayEnhance {

    private static boolean exist(List<List<Integer>> result, int a, int b, int c) {
        for(List<Integer> item : result) {
            if(item.contains(a) && item.contains(b) && item.contains(c)) {
                return true;
            }
        }
        return false;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        boolean ooo = false;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++) {
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++) {
                    if(!ooo && nums[i] == 0 && nums[j] == 0 && nums[k] == 0) {
                        ooo = true;
                        List<Integer> lists = new ArrayList<>();
                        lists.add(0);
                        lists.add(0);
                        lists.add(0);
                        result.add(lists);
                    }else if(nums[i] + nums[j] + nums[k] == 0) {
                        if (!exist(result, nums[i],nums[j],nums[k])) {
                            List<Integer> lists = new ArrayList<>();
                            lists.add(nums[i]);
                            lists.add(nums[j]);
                            lists.add(nums[k]);
                            result.add(lists);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static int myAtoi(String s) {
            if (s == null || s.trim().length() < 1) {
                return 0;
            }
            int aaa = 0;
            if (s.trim().charAt(0) == 43) {
                if(s.trim().length() > 1 && s.trim().charAt(1) == 45) {
                    return 0;
                }
                s = s.trim().substring(1);
            } else {
                s = s.trim();
            }
            if (s.length() < 1) {
                return 0;
            }
            if (s.charAt(0) >= 48 && s.charAt(0) <= 57) {
                int start = 0;
                int end = 0;
                for(int i=1;i<s.length();i++) {
                    if(s.charAt(i) >= 48 && s.charAt(i) <= 57){
                        end = i;
                    }else{
                        break;
                    }
                }
                String result = s.substring(start, end+1);
                try {
                    aaa = Integer.valueOf(result);
                }catch(NumberFormatException e){
                    aaa = Integer.MAX_VALUE;
                }
            }else if (s.charAt(0) == 45) {
                int start = 0;
                int end = 0;
                for(int i=1;i<s.length();i++) {
                    if(s.charAt(i) >= 48 && s.charAt(i) <= 57){
                        end = i;
                    }else{
                        break;
                    }
                }
                if(start == end) {
                    return 0;
                }
                String result = s.substring(start, end+1);
                try {
                    aaa = Integer.valueOf(result);
                }catch(NumberFormatException e){
                    aaa = Integer.MIN_VALUE;
                }
            }
            return aaa;
        }

    public static void main(String[] args) {
        /*int[] threeSum = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println(ArrayEnhance.threeSum(threeSum));*/
        String str[] = new String[] {" 42", "4392 aaaa", "words and 1234","-91283472332"};
        for(String s : str) {
            System.out.println(myAtoi(s));
        }
    }
}
