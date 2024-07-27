"""
https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array
You are given a 0-indexed integer array nums of length n. The number of ways to partition nums is the number of pivot indices that satisfy both conditions:

1 <= pivot < n
nums[0] + nums[1] + ... + nums[pivot - 1] == nums[pivot] + nums[pivot + 1] + ... + nums[n - 1]
You are also given an integer k. You can choose to change the value of one element of nums to k, or to leave the array unchanged.

Return the maximum possible number of ways to partition nums to satisfy both conditions after changing at most one element.



Example 1:

Input: nums = [2,-1,2], k = 3
Output: 1
Explanation: One optimal approach is to change nums[0] to k. The array becomes [3,-1,2].
There is one way to partition the array:
- For pivot = 2, we have the partition [3,-1 | 2]: 3 + -1 == 2.
Example 2:

Input: nums = [0,0,0], k = 1
Output: 2
Explanation: The optimal approach is to leave the array unchanged.
There are two ways to partition the array:
- For pivot = 1, we have the partition [0 | 0,0]: 0 == 0 + 0.
- For pivot = 2, we have the partition [0,0 | 0]: 0 + 0 == 0.
Example 3:

Input: nums = [22,4,-25,-20,-15,15,-16,7,19,-10,0,-13,-14], k = -33
Output: 4
Explanation: One optimal approach is to change nums[2] to k. The array becomes [22,4,-33,-20,-15,15,-16,7,19,-10,0,-13,-14].
There are four ways to partition the array.


Constraints:

n == nums.length
2 <= n <= 105
-105 <= k, nums[i] <= 105


from typing import List
from itertools import accumulate
from collections import Counter


class Solution:
    def waysToPartition(self, nums: List[int], k: int) -> int:
        # Calculate prefix sums for efficient subarray sum calculations
        prefix_sums = list(accumulate(nums))
        # The total sum of the array
        total_sum = prefix_sums[-1]

        # Initialize the pivots number of partitions
        pivots = 0

        # Check if there's a valid partition without changing any element
        if total_sum % 2 == 0:
            # Count how many times total_sum // 2 appears in prefix_sums
            # This represents the number of valid partitions in the original array
            pivots = prefix_sums[:-1].count(total_sum // 2)

        # Initialize a Counter for gaps after the current index
        # Gap is the difference between left and right sums: total_sum - (2 * prefix_sum)
        right_count = Counter(
            total_sum - (2 * prefix_sum) for prefix_sum in prefix_sums[:-1]
        )

        # Initialize a Counter for gaps before the current index
        left_counts = Counter()

        # Check what happens if we change the first number to k
        pivots = max(pivots, right_count[k - nums[0]])

        # Iterate through the array starting from the second element
        for prefix, x in zip(prefix_sums, nums[1:]):
            # Calculate the gap at the current position
            gap = total_sum - (2 * prefix)

            # Update counters:
            # Remove this gap from right_count as we've passed it
            right_count[gap] -= 1
            # Add this gap to left_counts as it's now before our current position
            left_counts[gap] += 1

            # Calculate and update the pivots number of partitions:
            # right_count[k - x]: number of valid partitions if we change current element to k
            # left_counts[x - k]: number of valid partitions before current element if we change it to k
            pivots = max(pivots, right_count[k - x] + left_counts[x - k])

        return pivots


# Test the solution
solution = Solution()
nums = [2, -1, 2]
k = 3
result = solution.waysToPartition(nums, k)
print(f"Maximum number of ways to partition: {result}")

"""

from typing import List
from itertools import accumulate
from collections import Counter


class Solution:
    def waysToPartition(self, nums: List[int], k: int) -> int:
        prefix_sums = list(accumulate(nums))
        total_sum = prefix_sums[-1]
        pivots = 0
        if total_sum % 2 == 0:
            pivots = prefix_sums[:-1].count(total_sum // 2)  # If no change

        right_count = Counter(
            [total_sum - (2 * prefix_sum) for prefix_sum in prefix_sums[:-1]]
        )
        left_counts = Counter()

        pivots = max(pivots, right_count[k - nums[0]])  # If we change first num

        for prefix, x in zip(prefix_sums, nums[1:]):
            gap = total_sum - 2 * prefix
            left_counts[gap] += 1
            right_count[gap] -= 1

            pivots = max(pivots, right_count[k - x] + left_counts[x - k])

        return pivots


solution = Solution()
nums = [22, 4, -25, -20, -15, 15, -16, 7, 19, -10, 0, -13, -14]
k = -33
result = solution.waysToPartition(nums, k)
print(f"Maximum number of ways to partition: {result}")
