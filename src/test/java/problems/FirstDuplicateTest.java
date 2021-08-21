package problems;

import org.junit.Assert;
import org.junit.Test;

public class FirstDuplicateTest {
    private final FirstDuplicate firstDuplicate = new FirstDuplicate();
    private final int[] input = new int[]{1, 2, 3, 2, 1};

    @Test
    public void testBruteForce() {
        Assert.assertEquals(2, firstDuplicate.bruteForce(input));
    }

    @Test
    public void testUsingSets() {
        Assert.assertEquals(2, firstDuplicate.usingSets(input));
    }

    @Test
    public void testSpaceOptimized() {
        Assert.assertEquals(2, firstDuplicate.spaceOptimized(input));
    }
}
