from python_problems.first_unique_character import FirstNonRepeatingUnique


def test_non_repeating_character():
    assert FirstNonRepeatingUnique("aabb").brute_force() == -1
    assert FirstNonRepeatingUnique("loveleetcode").brute_force() == 2
    assert FirstNonRepeatingUnique("leetcode").brute_force() == 0

    assert FirstNonRepeatingUnique("aabb").optimized_set() == -1
    assert FirstNonRepeatingUnique("loveleetcode").optimized_set() == 2
    assert FirstNonRepeatingUnique("leetcode").optimized_set() == 0

    assert FirstNonRepeatingUnique("aabb").optimized_list() == -1
    assert FirstNonRepeatingUnique("loveleetcode").optimized_list() == 2
    assert FirstNonRepeatingUnique("leetcode").optimized_list() == 0
