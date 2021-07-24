from python_problems.first_duplicates import FirstDuplicates


def test_first_duplicates():
    nums = [1, 2, 3, 2, 1]
    assert FirstDuplicates(nums).brute_force() == 2
    assert FirstDuplicates(nums).using_sets() == 2
    assert FirstDuplicates(nums).space_optimized() == 2
