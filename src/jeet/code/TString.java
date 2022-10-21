package jeet.code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hans on 3/21/2018.
 */
public class TString {

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for(int i=chars.length-1;i>=0;i--) {
            buffer.append(chars[i]);
        }
        return buffer.toString();
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Set<Integer> buffer = new HashSet<Integer>();
        int start = 0;
        int max = 1;
        while(start < s.length()) {
            buffer.add((int)s.charAt(start));
            for(int i=start+1;i<s.length();i++) {
                if (buffer.contains((int)s.charAt(i))) {
                    if (i - start > max) {
                        max = i - start;
                        //result = s.substring(start, i-1);
                    }
                    buffer.clear();
                    break;
                }else{
                    buffer.add((int)s.charAt(i));
                    if (i == s.length()-1 && buffer.size() > max) {
                        max = buffer.size();
                    }
                }
            }
            start++;
        }
        return max;
    }

}
