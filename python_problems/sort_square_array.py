"""
Problem Statement:
Given a sorted array of integers, return a sorted array of squares of the given array.
https://leetcode.com/problems/squares-of-a-sorted-array/
"""


class SortSquareArray:
    def __init__(self, array: [int]):
        self.array = array

    def brute_force(self) -> [int]:
        for i, num in enumerate(self.array):
            self.array[i] = num * num
        return self.array.sort()

    def sort_optimized(self) -> [int]:
        left = 0
        right = len(self.array) - 1
        output = [0] * len(self.array)
        for i, _ in enumerate(self.array):
            left_square = self.array[left] * self.array[left]
            right_square = self.array[right] * self.array[right]
            if left_square > right_square:
                output[len(output) - 1 - i] = left_square
                left = left + 1
            else:
                output[len(output) - 1 - i] = right_square
                right = right - 1
        return output
