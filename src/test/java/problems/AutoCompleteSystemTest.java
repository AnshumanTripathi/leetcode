package problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AutoCompleteSystemTest {
    private final AutocompleteSystem autocompleteSystem = new AutocompleteSystem(
            new String[]{"i love you", "island", "ironman", "i love leetcode"},
            new int[]{5, 3, 2, 2});

    @Test
    public void testAutoCompleteSystem() {
        List<String> suggestion = autocompleteSystem.input('i');
        Assert.assertArrayEquals(new String[]{"i love you", "island", "i love leetcode"}, suggestion.toArray(new String[0]));

        suggestion = autocompleteSystem.input(' ');
        Assert.assertArrayEquals(new String[]{"i love you", "i love leetcode"}, suggestion.toArray(new String[0]));

        suggestion = autocompleteSystem.input('a');
        Assert.assertArrayEquals(new String[]{}, suggestion.toArray(new String[0]));

        suggestion = autocompleteSystem.input('#');
        Assert.assertArrayEquals(new String[]{}, suggestion.toArray(new String[0]));

        suggestion = autocompleteSystem.input('i');
        Assert.assertArrayEquals(new String[]{"i love you", "island", "i love leetcode"}, suggestion.toArray(new String[0]));

        suggestion = autocompleteSystem.input(' ');
        Assert.assertArrayEquals(new String[]{"i love you", "i love leetcode", "i a"}, suggestion.toArray(new String[0]));

        suggestion = autocompleteSystem.input('a');
        Assert.assertArrayEquals(new String[]{"i a"}, suggestion.toArray(new String[0]));

        suggestion = autocompleteSystem.input('#');
        Assert.assertArrayEquals(new String[]{}, suggestion.toArray(new String[0]));
    }
}
