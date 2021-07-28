"""
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to
the target. You may assume that each input would have exactly one solution, and you may not use the same element twice.

https://leetcode.com/problems/two-sum/
"""


class TwoSum:
    def __init__(self, nums: [int], target: int):
        self.nums = nums
        self.target = target

    def two_sum(self) -> [int]:
        seen = {}
        for i, num in enumerate(self.nums):
            if self.target - num in seen:
                return [seen[self.target - num], i]
            seen[num] = i
