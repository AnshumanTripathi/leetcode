from python_problems.maximum_subarray import MaximumSubArray


def test_max_sub_array():
    nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    max_sub_array = MaximumSubArray()
    assert max_sub_array.max_sub_array(nums) == 6

    nums = [1]
    assert max_sub_array.max_sub_array(nums) == 1

    nums = [5, 4, -1, 7, 8]
    assert max_sub_array.max_sub_array(nums) == 23
