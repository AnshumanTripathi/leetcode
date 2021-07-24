"""
Given an array of integers where all the elements of the integers are smaller than the length,
find the first duplicate
https://leetcode.com/problems/find-the-duplicate-number/
"""
from sys import maxsize


class FirstDuplicates:
    def __init__(self, nums):
        self.nums = nums

    def brute_force(self) -> int:
        i = 0
        first_duplicate = maxsize
        while i < len(self.nums):
            j = i + 1
            while j < len(self.nums):
                if self.nums[i] == self.nums[j]:
                    first_duplicate = min(j, first_duplicate)
                j += 1
            i += 1

        if first_duplicate == maxsize:
            return -1

        return self.nums[first_duplicate]

    def using_sets(self):
        seen = set([])
        for num in self.nums:
            if num in seen:
                return num
            else:
                seen.add(num)

        return -1

    def space_optimized(self):
        for index in self.nums:
            if self.nums[abs(index)] > 0:
                self.nums[abs(index)] = self.nums[abs(index)] * -1
            else:
                return abs(index)
        return -1
