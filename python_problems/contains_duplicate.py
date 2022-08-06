# https://leetcode.com/problems/contains-duplicate/
from typing import List


class ContainsDuplicate:
    def contains_duplicate(self, nums: List[int]) -> bool:
        seen = set()
        for num in nums:
            if num in seen:
                return True
            seen.add(num)
        return False

    def contains_duplicate_optimized(self, nums: List[int]) -> bool:
        nums_set = set(nums)
        if len(nums_set) == len(nums):
            return False
        return True
