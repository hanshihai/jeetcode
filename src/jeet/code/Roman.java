package jeet.code;

import java.util.HashMap;

public class Roman {
    public static String[] chars10 = new String [] {"I", "X", "C", "M"};
    public static String[] chars5 = new String[] {"V","L","D"};

    public static String intToRoman(int num) {
        int charIndex = 0;
        StringBuffer buffer = new StringBuffer();
        int input = num;
        while(input > 0) {
            if(input == 10) {
                buffer.append(chars10[charIndex+1]);
                break;
            }
            int split = input % 10;
            switch(split){
                case 9:
                    buffer.append(chars10[charIndex+1]);
                    buffer.append(chars10[charIndex]);
                    break;
                case 4:
                    buffer.append(chars5[charIndex]);
                    buffer.append(chars10[charIndex]);
                    break;
                case 1:
                    buffer.append(chars10[charIndex]);
                    break;
                case 2:
                    buffer.append(chars10[charIndex]);
                    buffer.append(chars10[charIndex]);
                    break;
                case 3:
                    buffer.append(chars10[charIndex]);
                    buffer.append(chars10[charIndex]);
                    buffer.append(chars10[charIndex]);
                    break;
                case 5:
                    buffer.append(chars5[charIndex]);
                    break;
                case 6:
                    buffer.append(chars10[charIndex]);
                    buffer.append(chars5[charIndex]);
                    break;
                case 7:
                    buffer.append(chars10[charIndex]);
                    buffer.append(chars10[charIndex]);
                    buffer.append(chars5[charIndex]);
                    break;
                case 8:
                    buffer.append(chars10[charIndex]);
                    buffer.append(chars10[charIndex]);
                    buffer.append(chars10[charIndex]);
                    buffer.append(chars5[charIndex]);
                    break;
            }
            input = input / 10;
            charIndex++;
        }
        return buffer.reverse().toString();
    }

    private static HashMap<String, Integer> dict = new HashMap<>();

    static {
        dict.put("I", 1);
        dict.put("V", 5);
        dict.put("X", 10);
        dict.put("L", 50);
        dict.put("C", 100);
        dict.put("D", 500);
        dict.put("M", 1000);
        dict.put("IX", 9);
        dict.put("IV", 4);
        dict.put("XC", 90);
        dict.put("XL", 40);
        dict.put("CM", 900);
        dict.put("CD", 400);
    }
    public static int romanToInt(String s) {
        int index = 0;
        int sum = 0;
        boolean flag = false;
        while(index < s.length() - 1) {
            String key = s.substring(index,index+2);
            Integer dic = dict.get(key);
            if(dic != null && dic.intValue() != 0) {
                sum += dic.intValue();
                index += 2;
                flag = true;
            }else{
                sum += dict.get(key.substring(0, 1));
                index += 1;
                flag = false;
            }
        }
        if(!flag || index < s.length()) {
            String key = s.substring(s.length()-1);
            sum += dict.get(key);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Roman.romanToInt("MDCXCV"));
        System.out.println(Roman.romanToInt("CI"));
        System.out.println(Roman.romanToInt("C"));
        System.out.println(Roman.romanToInt("LVIII"));
        System.out.println(Roman.romanToInt("MCMXCIV"));
        /*System.out.println(Roman.intToRoman(30));
        System.out.println(Roman.intToRoman(101));
        System.out.println(Roman.intToRoman(100));
        System.out.println(Roman.intToRoman(58));
        System.out.println(Roman.intToRoman(1994));*/
    }
}
