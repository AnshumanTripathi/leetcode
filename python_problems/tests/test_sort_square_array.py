from python_problems.sort_square_array import SortSquareArray


def test_sort_square_array():
    assert [0, 1, 9, 16, 100] == SortSquareArray([-4, -1, 0, 3, 10]).sort_optimized()
    assert [4, 9, 9, 49, 121] == SortSquareArray([-7, -3, 2, 3, 11]).sort_optimized()
