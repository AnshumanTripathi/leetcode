package problems;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithoutRepeatTest {
    private final LongestSubstringWithoutRepeat longestSubstringWithoutRepeat = new LongestSubstringWithoutRepeat();

    @Test
    public void testLongestSubstringWithoutRepeat() {
        int len = longestSubstringWithoutRepeat.lengthOfLongestSubstring("abcabcbb");
        Assert.assertEquals(3, len);

        len = longestSubstringWithoutRepeat.lengthOfLongestSubstring("bbbbb");
        Assert.assertEquals(1, len);

        len = longestSubstringWithoutRepeat.lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(3, len);

        len = longestSubstringWithoutRepeat.lengthOfLongestSubstring("");
        Assert.assertEquals(0, len);
    }
}
