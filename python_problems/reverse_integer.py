"""
https://leetcode.com/problems/reverse-integer

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21


Constraints:

-231 <= x <= 231 - 1
"""


class ReverseInteger:
    def reverse(self, x: int) -> int:
        if x < (-2) ^ 31 and x > ((2 ^ 31) - 1):
            return 0
        rev = 0
        is_neg = False
        if x < 0:
            is_neg = True
        x = abs(x)
        while x != 0:
            rev = (rev * 10) + (x % 10)
            x = x // 10
        if is_neg:
            rev = rev * -1
        return rev
