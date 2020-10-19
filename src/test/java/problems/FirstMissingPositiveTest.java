package problems;

import org.junit.Assert;
import org.junit.Test;

public class FirstMissingPositiveTest {
    private final FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
    private final int[] input1 = new int[]{1,2,0};
    private final int[] input2 = new int[]{3,4,-1,1};
    private final int[] input3 = new int[]{7,8,9,11,12};
    private final int[] input4 = new int[]{0, 1, 2};

    @Test
    public void testFirstMissingPositive() {
        Assert.assertEquals(3, firstMissingPositive.firstMissingPositive(input1));
        Assert.assertEquals(2, firstMissingPositive.firstMissingPositive(input2));
        Assert.assertEquals(1, firstMissingPositive.firstMissingPositive(input3));
        Assert.assertEquals(3, firstMissingPositive.firstMissingPositive(input4));
    }

    @Test
    public void testFindFast() {
        Assert.assertEquals(3, firstMissingPositive.findFast(input1));
        Assert.assertEquals(2, firstMissingPositive.findFast(input2));
        Assert.assertEquals(1, firstMissingPositive.findFast(input3));
        Assert.assertEquals(3, firstMissingPositive.findFast(input4));
    }
}
