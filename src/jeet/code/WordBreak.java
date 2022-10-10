package jeet.code;

import java.util.List;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (null == s || s.trim().length() <= 0 || null == wordDict || wordDict.size() == 0) {
            return false;
        }
        if (wordDict.contains(s)) {
            return true;
        }
        if (wordBreak_greedy(s, wordDict)) {
            return true;
        }
        return wordBreak_stingy(s, wordDict);
    }

    public static boolean wordBreak_stingy(String s, List<String> wordDict) {
        int minLength = s.length();
        int maxLength = 0;
        for(String word : wordDict) {
            if (null != word && word.length() < minLength) {
                minLength = word.length();
            }
            if (null != word && word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        int start = 0;
        int length = minLength;
        int i = minLength;
        while(i < 300) {
            String w = s.substring(start, start + length);
            if (wordDict.contains(w)) {
                start = start + length;
                length = minLength;
                if (start == s.length()) {
                    return true;
                }
            } else {
                length += 1;
            }
            if (start + length > s.length()) {
                break;
            }
            i++;
        }
        return false;
    }

    public static boolean wordBreak_greedy(String s, List<String> wordDict) {
        int minLength = s.length();
        int maxLength = 0;
        for(String word : wordDict) {
            if (null != word && word.length() < minLength) {
                minLength = word.length();
            }
            if (null != word && word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        int start = 0;
        int length = maxLength;
        int i = minLength;
        while(i < 300) {
            if (start + length > s.length()) {
                length = s.length() - start;
            }
            String w = s.substring(start, start + length);
            if (wordDict.contains(w)) {
                start = start + length;
                length = maxLength;
                if (start == s.length()) {
                    return true;
                }
            } else {
                length -= 1;
            }
            if (length < minLength) {
                break;
            }
            i++;
        }
        return false;
    }
}
