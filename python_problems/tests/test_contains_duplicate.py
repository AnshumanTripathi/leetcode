from python_problems.contains_duplicate import ContainsDuplicate


def test_contains_duplicate():
    nums = [1, 2, 3, 1]
    check = ContainsDuplicate()

    assert check.contains_duplicate(nums)

    nums = [1, 2, 3, 4]
    assert not check.contains_duplicate(nums)

    nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
    assert check.contains_duplicate(nums)


def test_contains_duplicate_optimized():
    nums = [1, 2, 3, 1]
    check = ContainsDuplicate()

    assert check.contains_duplicate_optimized(nums)

    nums = [1, 2, 3, 4]
    assert not check.contains_duplicate_optimized(nums)

    nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
    assert check.contains_duplicate_optimized(nums)
