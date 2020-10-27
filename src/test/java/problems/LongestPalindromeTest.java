package problems;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeTest {

    private final LongestPalindrome longestPalindrome = new LongestPalindrome();

    @Test
    public void testLongestPalindrome() {
        Assert.assertEquals(longestPalindrome.longestPalindrome("babad"), "bab");
        Assert.assertEquals(longestPalindrome.longestPalindrome("abcde"), "a");
        Assert.assertEquals(longestPalindrome.longestPalindrome("a"), "a");
        Assert.assertEquals(longestPalindrome.longestPalindrome("ccd"), "cc");
    }
}
