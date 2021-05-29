from python_problems.longest_non_repeating_substring import longest_subs

def test_longest_repeating_substring():
    assert longest_sub("pwwkew") == 3
    assert longest_sub("") == 0
    assert longest_sub("abcabcd") == 4
    assert False
