package jeet.code;

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
}
