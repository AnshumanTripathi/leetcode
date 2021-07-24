# https://leetcode.com/problems/longest-substring-without-repeating-characters/
class LongestNonRepeating:
    def __init__(self, input):
        self.s = input

    def longest_subs(self) -> int:
        i = 0
        j = 0
        longest = 0
        checker = set()
        while i < len(self.s) and j < len(self.s):
            if self.s[j] not in checker:
                checker.add(self.s[j])
                j += 1
                longest = max(longest, j - i)
            else:
                checker.remove(self.s[i])
                i += 1
        return longest
