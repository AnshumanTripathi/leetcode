package problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestLetterCombinationsInPhoneNumbers {

    private final LetterCombinationsInPhoneNumbers letterCombinationsInPhoneNumbers = new LetterCombinationsInPhoneNumbers();

    @Test
    public void testLetterCombinationsInPhoneNumbers() {
        List<String> digits = letterCombinationsInPhoneNumbers.letterCombinations("23");
        Assert.assertArrayEquals(new String[]{"ad","ae","af","bd","be","bf","cd","ce","cf"}, digits.toArray(new String[0]));

        digits = letterCombinationsInPhoneNumbers.letterCombinations("");
        Assert.assertArrayEquals(new String[]{}, digits.toArray(new String[0]));

        digits = letterCombinationsInPhoneNumbers.letterCombinations("2");
        Assert.assertArrayEquals(new String[]{"a","b","c"}, digits.toArray(new String[0]));
    }
}
