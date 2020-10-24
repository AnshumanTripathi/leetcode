from python_problems import valid_parenthesis


def test_valid_parenthesis():
    assert valid_parenthesis.is_valid("()")
    assert valid_parenthesis.is_valid("()[]{}")
    assert valid_parenthesis.is_valid("[()]")
    assert not valid_parenthesis.is_valid("[(])")
    assert not valid_parenthesis.is_valid("[")
