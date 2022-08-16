from python_problems.two_sum import TwoSum
from python_problems.two_sum_stream import TwoSumStream


def test_two_sum():
    assert TwoSum([2, 7, 11, 15], 9).two_sum() == [0, 1]
    assert TwoSum([3, 2, 4], 6).two_sum() == [1, 2]
    assert TwoSum([3, 3], 6).two_sum() == [0, 1]


def test_two_sum_stream():
    two_sum_stream = TwoSumStream()
    two_sum_stream.add(0)

    assert not two_sum_stream.find(0)

    two_sum_stream.add(0)
    assert two_sum_stream.find(0)

    two_sum_stream = TwoSumStream()
    two_sum_stream.add(3)
    two_sum_stream.add(1)
    two_sum_stream.add(2)

    assert two_sum_stream.find(3)

    two_sum_stream = TwoSumStream()
    two_sum_stream.add(1)
    two_sum_stream.add(-1)
    assert two_sum_stream.find(0)

    two_sum_stream = TwoSumStream()
    two_sum_stream.add(1)
    two_sum_stream.add(2)
    assert not two_sum_stream.find(1)
