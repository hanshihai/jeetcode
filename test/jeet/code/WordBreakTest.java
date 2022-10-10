package jeet.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WordBreakTest {

    @Test
    public void testWordBreak() {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        assertThat(true, is(WordBreak.wordBreak(s, wordDict)));
    }

    @Test
    public void testWordBreak_AAA() {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        assertThat(true, is(WordBreak.wordBreak(s, wordDict)));
    }

    @Test
    public void testWordBreak_Stingy() {
        String s = "abcd";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("abc");
        wordDict.add("b");
        wordDict.add("cd");
        assertThat(true, is(WordBreak.wordBreak(s, wordDict)));
    }

    @Test
    public void testWordBreak_False() {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("cat");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        assertThat(false, is(WordBreak.wordBreak(s, wordDict)));
    }
}
