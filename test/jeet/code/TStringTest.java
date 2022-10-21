package jeet.code;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TStringTest {

    @Test
    public void testLengthOfLongestSubstring() {
        assertThat(3, is(TString.lengthOfLongestSubstring("bwf")));
        assertThat(2, is(TString.lengthOfLongestSubstring("au")));
        assertThat(1, is(TString.lengthOfLongestSubstring("aa")));
        assertThat(3, is(TString.lengthOfLongestSubstring("abcabcabc")));
        assertThat(3, is(TString.lengthOfLongestSubstring("pwwkew")));
        assertThat(1, is(TString.lengthOfLongestSubstring("bbbbb")));
    }
}
