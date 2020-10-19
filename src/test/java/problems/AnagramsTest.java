package problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnagramsTest {
    private final Anagrams anagrams = new Anagrams();

    @Test
    public void testFindingAnagrams() {
    List<Integer> indices = anagrams.findAnagramsOptimized("cbaebabacd", "abc");
    Assert.assertArrayEquals(new Integer[]{0, 6}, indices.toArray(new Integer[0]));
    indices = anagrams.findAnagramsArray("cbaebabacd", "abc");
    Assert.assertArrayEquals(new Integer[]{0, 6}, indices.toArray(new Integer[0]));
    }

    @Test
    public void isValidAnagram() {
        Assert.assertTrue(anagrams.isValidAnagram("anagram", "nagaram"));
        Assert.assertFalse(anagrams.isValidAnagram("cat", "rat"));
    }

    @Test
    public void testGroupAnagrams() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = anagrams.groupAnagrams(input);
        Assert.assertArrayEquals(new String[]{"bat"}, result.get(0).toArray(new String[0]));
        Assert.assertArrayEquals(new String[]{"tan", "nat"}, result.get(1).toArray(new String[0]));
        Assert.assertArrayEquals(new String[]{"eat", "tea", "ate"}, result.get(2).toArray(new String[0]));
    }

    @Test
    public void testAnagramMappings() {
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};

        int[] result = anagrams.anagramMappings(A, B);
        Assert.assertArrayEquals(new int[]{1, 4, 3, 2, 0}, result);
    }
}
