from python_problems import longest_consecutive_sequence


def test_longest_consecutive_sequence():
    longest_seq = longest_consecutive_sequence.LongestConsecutiveSequence()
    test = [100, 4, 200, 1, 3, 2]
    seq = longest_seq.longestConsecutive(test)
    assert seq == 4

    test = [0, -1]
    seq = longest_seq.longestConsecutive(test)
    assert seq == 2

    test = [9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6]
    seq = longest_seq.longestConsecutive(test)
    assert seq == 7
