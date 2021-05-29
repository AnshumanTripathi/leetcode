from python_problems.longest_non_repeating_substring import LongestNonRepeating


def test_longest_repeating_substring():
    assert LongestNonRepeating("pwwkew").longest_subs() == 3
    assert LongestNonRepeating("").longest_subs() == 0
    assert LongestNonRepeating("abcdabc").longest_subs() == 4
    assert LongestNonRepeating("dvdf").longest_subs() == 3

