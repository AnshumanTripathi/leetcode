from python_problems import reverse_integer


def test_reverse():
    rev_int = reverse_integer.ReverseInteger()
    test = 1234
    assert rev_int.reverse(test) == 4321

    test = -123
    assert rev_int.reverse(test) == -321

    test = 120
    assert rev_int.reverse(test) == 21
