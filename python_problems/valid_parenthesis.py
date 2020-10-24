brackets_dict = {
    ")": "(",
    "}": "{",
    "]": "["
}


def is_valid(input_expr) -> bool:
    if input_expr is None or len(input_expr) == 0:
        return False

    stack = []

    for i in input_expr:
        if i in brackets_dict:
            if len(stack) == 0:
                return False
            bracket = stack.pop()
            if brackets_dict[i] != bracket:
                return False
        else:
            stack.append(i)

    return len(stack) == 0


