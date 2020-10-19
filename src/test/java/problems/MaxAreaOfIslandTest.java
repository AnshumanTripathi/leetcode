package problems;

import org.junit.Assert;
import org.junit.Test;

public class MaxAreaOfIslandTest {
    private static final int[][] input = new int[][]{
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };

    private static final int[][] zeroInput = new int[][]{
            {0,0,0,0,0,0,0,0}
    };
    private final MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();

    @Test
    public void testMaxAreaOfIsland() {
        Assert.assertEquals(6, maxAreaOfIsland.maxAreaOfIsland(input));
        Assert.assertEquals(0, maxAreaOfIsland.maxAreaOfIsland(zeroInput));
    }
}
