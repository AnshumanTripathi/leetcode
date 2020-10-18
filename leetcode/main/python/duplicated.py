def solution(A):

    result = {}
    for i in range(len(A)):
        if A[i] in result:
            result[A[i]] += 1
        else:
            result[A[i]] = 1

    str_template = "{}:{}"
    result_str = ""
    for key, value in result.items():
        if value > 1:
            result_str += str_template.format(key, value) + " "

    return result_str


if __name__ == "__main__":
    print(solution(["one", "two", "one", "five", "five"]))
