from python_problems import longest_non_repeating_substring as longest

def test_longest_repeating_substring():
    assert longest.longest_sub("pwwkew") == 3
    assert longest.longest_sub("") == 0
    assert longest.longest_sub("abcabcd") == 4
