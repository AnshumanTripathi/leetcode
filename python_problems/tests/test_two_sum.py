from python_problems.two_sum import TwoSum


def test_two_sum():
    assert TwoSum([2, 7, 11, 15], 9).two_sum() == [0, 1]
    assert TwoSum([3, 2, 4], 6).two_sum() == [1, 2]
    assert TwoSum([3, 3], 6).two_sum() == [0, 1]
