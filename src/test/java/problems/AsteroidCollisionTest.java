package problems;

import org.junit.Assert;
import org.junit.Test;

public class AsteroidCollisionTest {

    private final AsteroidCollision asteroidCollision = new AsteroidCollision();

    @Test
    public void testAsteroidCollision() {
        int[] result = asteroidCollision.asteroidCollision(new int[]{1, -2, -2, -2});
        Assert.assertArrayEquals(new int[]{-2, -2, -2}, result);
    }

}
