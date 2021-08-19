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

        private static boolean isBack(int i, int j, List<String> passed) {
            return passed.contains(i+"-"+j);
        }

        private static boolean checkExist(char[][] board, String word, int indexStr, int i, int j, List<String> passed) {
            if (indexStr == word.length()) {
                return true;
            }
            boolean result = false;
            if (i-1 >= 0 && board[i-1][j] == word.charAt(indexStr) && !isBack(i-1, j, passed)) {
                List<String> subPassed = new ArrayList<>();
                subPassed.addAll(passed);
                subPassed.add(String.valueOf(i-1)+"-"+j);
                result = checkExist(board, word, indexStr + 1, i-1, j, subPassed);
                if (result) {
                    return true;
                }
            }
            if (i+1 < board.length && board[i+1][j] == word.charAt(indexStr) && !isBack(i+1, j, passed)) {
                List<String> subPassed = new ArrayList<>();
                subPassed.addAll(passed);
                subPassed.add(String.valueOf(i+1)+"-"+j);
                result = checkExist(board, word, indexStr + 1, i+1, j, subPassed);
                if (result) {
                    return true;
                }
            }
            if (j-1 >= 0 && board[i][j-1] == word.charAt(indexStr) && !isBack(i, j-1, passed)) {
                List<String> subPassed = new ArrayList<>();
                subPassed.addAll(passed);
                subPassed.add(i+"-"+String.valueOf(j-1));
                result = checkExist(board, word, indexStr + 1, i, j-1, subPassed);
                if (result) {
                    return true;
                }
            }
            if (j+1 < board[0].length && board[i][j+1] == word.charAt(indexStr) && !isBack(i, j+1, passed)) {
                List<String> subPassed = new ArrayList<>();
                subPassed.addAll(passed);
                subPassed.add(i+"-"+String.valueOf(j+1));
                result = checkExist(board, word, indexStr + 1, i, j+1, subPassed);
                if (result) {
                    return true;
                }
            }
            return false;
        }

    public static boolean exist(char[][] board, String word) {
        if(word == null || word.trim().length() < 1
            || board == null || board.length < 1 || board[0] == null || board[0].length < 1) {
            return false;
        }
        int length = board.length;
        int width = board[0].length;

        if (word.length() > length * width) {
            return false;
        }

        for(int i=0;i<length;i++) {
            for(int j=0;j<width;j++) {
                if (board[i][j] == word.charAt(0)) {
                    List<String> passed = new ArrayList<>();
                    passed.add(i+"-"+j);
                    boolean checked = checkExist(board, word, 1, i, j, passed);
                    if (checked) {
                        return true;
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        char[][] board = new char[][] {{'c','a','a'},{'a','a','a'},{'b','c','d'}};
        System.out.println(exist(board, "aab"));

        /*char[] cha = new char[] {'a','b','c','e'};
        char[] chb = new char[] {'s','f','c','s'};
        char[] chc = new char[] {'a','d','e','e'};
        char[][] board = new char[][] {cha, chb, chc};

        System.out.println(exist(board, "see"));*/

        /*char[][] oneBoard = new char[][] {{'a','a','b','a','a','b'},{'a','a','b','b','b','a'},{'a','a','a','a','b','a'},{'b','a','b','b','a','b'},{'a','b','b','a','b','a'},{'b','a','a','a','a','b'}};

        System.out.print(exist(oneBoard, "bbbaabbbbbab"));*/

        /*int[] threeSum = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println(ArrayEnhance.threeSum(threeSum));*/
        /*String str[] = new String[] {" 42", "4392 aaaa", "words and 1234","-91283472332"};
        for(String s : str) {
            System.out.println(myAtoi(s));
        }*/
    }
}
