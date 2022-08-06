from typing import List


class MaximumSubArray:
    def max_sub_array(self, nums: List[int]) -> int:
        max_sum = current_sum = nums[0]
        if len(nums) == 1:
            return nums[0]
        for i, num in enumerate(nums[1:], start=1):
            current_sum = max(current_sum + num, num)
            max_sum = max(current_sum, max_sum)
        return max_sum
