from python_problems.Parenthesis import Parenthesis


def test_valid_parenthesis():
    p = Parenthesis()
    assert p.is_valid("()")
    assert p.is_valid("()[]{}")
    assert p.is_valid("[()]")
    assert not p.is_valid("[(])")
    assert not p.is_valid("[")


def test_generate_parenthesis():
    p = Parenthesis()
    expected = ["((()))", "(()())", "(())()", "()(())", "()()()"]
    actual = p.generate(3)
    assert len(actual) == 5

    # Zip joins tuples together using iterator on both lists
    # https://www.w3schools.com/python/ref_func_zip.asp
    assert all(a == e for a, e in zip(actual, expected))

    assert len(p.generate(1)) == 1
    assert all(a == e for a, e in zip(p.generate(1), ["()"]))
