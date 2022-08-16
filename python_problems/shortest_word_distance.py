# https://leetcode.com/problems/shortest-word-distance/
from typing import List
from collections import defaultdict


class WordsDistance:
    def __init__(self, words_dict: List[str]):
        if words_dict is not None:
            self.words_dict = defaultdict(list)

        for i, word in enumerate(words_dict):
            self.words_dict[word].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        word1_indices = self.words_dict[word1]
        word2_indices = self.words_dict[word2]
        left = right = 0
        distance = float("inf")

        while left < len(word1_indices) and right < len(word2_indices):
            distance = min(distance, abs(word1_indices[left] - word2_indices[right]))
            if word1_indices[left] < word2_indices[right]:
                left += 1
            else:
                right += 1
        return distance
