package problems;

import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesisTest {
    private final ValidParenthesis validParenthesis = new ValidParenthesis();

    @Test
    public void testValidParenthesis() {
        Assert.assertTrue(validParenthesis.isValid("()[]{}"));
        Assert.assertFalse(validParenthesis.isValid("(]"));
        Assert.assertTrue(validParenthesis.isValid("{[]}"));
        Assert.assertFalse(validParenthesis.isValid("([)]"));
        Assert.assertTrue(validParenthesis.isValid("()"));
    }
}
