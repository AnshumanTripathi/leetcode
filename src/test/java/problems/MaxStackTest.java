package problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxStackTest {
    private final MaxStack stack = new MaxStack();

    @Before
    public void setUp() {
        stack.push(-1);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }

    @Test
    public void testMaxStack() {
        Assert.assertEquals(5, stack.top());
        Assert.assertEquals(5, stack.peekMax());
        stack.popMax();
        Assert.assertEquals(4, stack.peekMax());
        stack.popMax();
        Assert.assertEquals(3, stack.top());
        stack.pop();
        Assert.assertEquals(2, stack.peekMax());
    }
}
