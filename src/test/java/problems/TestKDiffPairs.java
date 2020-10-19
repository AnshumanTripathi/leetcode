package problems;

import org.junit.Assert;
import org.junit.Test;

public class TestKDiffPairs {
    private final KDiffPairs kDiffPairs = new KDiffPairs();

    @Test
    public void testKDiffPairs() {
        Assert.assertEquals(2, kDiffPairs.findPairs(new int[]{3,1,4,1,5}, 2));
        Assert.assertEquals(4, kDiffPairs.findPairs(new int[]{1,2,3,4,5}, 1));
        Assert.assertEquals(1, kDiffPairs.findPairs(new int[]{1,3,1,5,4}, 0));
        Assert.assertEquals(2, kDiffPairs.findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3));
        Assert.assertEquals(2, kDiffPairs.findPairs(new int[]{-1,-2,-3}, 1));
    }
}
