"""
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
https://leetcode.com/problems/first-unique-character-in-a-string/
"""
from collections import defaultdict


class FirstNonRepeatingUnique:
    def __init__(self, input_str: str):
        self.str = input_str

    def brute_force(self) -> int:
        for i, ch in enumerate(self.str):
            seen = False
            for j, sub_ch in enumerate(self.str):
                if ch == sub_ch and not i == j:
                    seen = True
                    break

            if not seen:
                return i
        return -1

    def optimized_set(self):
        seen = dict()
        seen = defaultdict(lambda: 0, seen)
        for ch in self.str:
            seen[ch] = seen[ch] + 1

        for ch, index in seen.items():
            if index == 1:
                return self.str.index(ch)

        return -1

    def optimized_list(self):
        seen = [0] * 26

        for ch in self.str:
            # https://www.geeksforgeeks.org/ord-function-python/
            index = ord(ch.upper()) - 65
            seen[index] = seen[index] + 1

        for i, ch in enumerate(self.str):
            index = ord(ch.upper()) - 65
            if seen[index] == 1:
                return i
        return -1
