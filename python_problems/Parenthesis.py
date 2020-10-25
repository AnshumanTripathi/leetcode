from typing import List


class Parenthesis:
    def __init__(self):
        self.brackets_dict = {
            ")": "(",
            "}": "{",
            "]": "["
        }

    def is_valid(self, input_expr: str) -> bool:
        """
        Check if the given parenthesis expression is valid.
        https://leetcode.com/problems/generate-parentheses/
        :param input_expr: input expression
        :return: True if expression is valid else False
        """
        if input_expr is None or len(input_expr) == 0:
            return False

        stack = []

        for i in input_expr:
            if i in self.brackets_dict:
                if len(stack) == 0:
                    return False
                bracket = stack.pop()
                if self.brackets_dict[i] != bracket:
                    return False
            else:
                stack.append(i)

        return len(stack) == 0

    def generate(self, n: int) -> List[str]:
        """
        Given a number, generate all possible combinatins of valid parenthesis
        https://leetcode.com/problems/generate-parentheses/
        :param n: Number of parenthesis set to generate combinations
        :return:
        """
        output = []
        if n == 0:
            return output
        elif n == 1:
            return ["()"]
        else:
            self._generate_combos("", n, n, output)
            return output

    def _generate_combos(self,
                         input_str: str,
                         left: int,
                         right: int,
                         output: List[str]) -> None:

        if left == 0 and right == 0:
            output.append(input_str)
            return
        if left > 0:
            self._generate_combos(input_str + "(", left - 1, right, output)
        if right > left:
            self._generate_combos(input_str + ")", left, right - 1, output)
