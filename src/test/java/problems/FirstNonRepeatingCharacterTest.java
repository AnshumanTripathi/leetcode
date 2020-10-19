package problems;

import org.junit.Assert;
import org.junit.Test;

public class FirstNonRepeatingCharacterTest {
    private static final String INPUT = "aaabbbcddd";
    private final FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();

    @Test
    public void testFirstNonRepeatingCharacter() {
        Assert.assertEquals('c', firstNonRepeatingCharacter.bruteForce(INPUT));
        Assert.assertEquals('c', firstNonRepeatingCharacter.usingMaps(INPUT));
        Assert.assertEquals('c', firstNonRepeatingCharacter.usingCharArray(INPUT));
        Assert.assertEquals('c', firstNonRepeatingCharacter.usingIndexOf(INPUT));
    }
}
