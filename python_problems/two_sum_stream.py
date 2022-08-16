# https://leetcode.com/problems/two-sum-iii-data-structure-design/
from collections import defaultdict


class TwoSumStream:
    def __init__(self):
        self.input = defaultdict(int)

    def add(self, number: int) -> None:
        self.input[number] += 1

    def find(self, value: int) -> bool:
        for key in self.input.keys():
            compliment = value - key
            if key != compliment:
                if compliment in self.input:
                    return True
            elif self.input[key] > 1:
                return True
        return False

