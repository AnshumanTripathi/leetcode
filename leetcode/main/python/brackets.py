def is_valid(s):

    if s is None or s == "":
        return True

    brackets_dict = {
        ')': '(',
        ']': '[',
        '}': '{'
    }

    stack = []

    for ch in s:
        if ch in brackets_dict.keys():
            if len(stack) == 0:
                return False
            bracket = stack.pop()
            if bracket != brackets_dict.get(ch):
                return False
        else:
            stack.append(ch)

    return len(stack) == 0


if __name__ == '__main__':
    str = "([)]"
    print(is_valid(str))