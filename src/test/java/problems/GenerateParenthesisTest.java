package problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GenerateParenthesisTest {
    private final GenerateParenthesis generateParenthesis = new GenerateParenthesis();

    @Test
    public void testGenerateAnagrams() {
        List<String> result = generateParenthesis.generateParenthesis(3);
        Assert.assertArrayEquals(new String[]{"((()))", "(()())", "(())()", "()(())", "()()()"},  result.toArray(new String[0]));
    }
}
