package problems;

import org.junit.Assert;
import org.junit.Test;

public class MedianFinderTest {
    private final MedianFinder medianFinder = new MedianFinder();

    @Test
    public void testMedianFinder() {
        Assert.assertEquals(0.0, medianFinder.findMedian(), 0.0);
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        Assert.assertEquals(1.5, medianFinder.findMedian(), 0.0);
        medianFinder.addNum(3);
        Assert.assertEquals(2, medianFinder.findMedian(), 0.0);
    }
}
