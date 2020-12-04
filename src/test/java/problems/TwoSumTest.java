package problems;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {
    private final TwoSum twoSum = new TwoSum();

    @Test
    public void testTwoSum() {
        Assert.assertArrayEquals(twoSum.twoSum(new int[]{2, 7, 11, 15, 3, 8, 16}, 19), new int[]{5, 2});
        Assert.assertArrayEquals(twoSum.twoSum(new int[]{2, 7, 11, 15, 3, 8, 16}, 9), new int[]{1, 0});
        Assert.assertArrayEquals(twoSum.twoSum(new int[]{2, 7, 11, 15, 3, 8, 16}, 6), new int[]{});
    }
}
