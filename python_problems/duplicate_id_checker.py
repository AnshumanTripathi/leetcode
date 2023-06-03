import array
import hashlib
import math
from threading import Lock
from typing import List


class ProbabilisticDuplicateChecker:
    def __init__(self, size, hashes):
        """
        Use bloom filter for a probabilistic check for duplicates
        :param size: initial size of the bloom filter
        :param hashes: Number of hashes used in the filter
        """
        self.size = size
        self.hashes = hashes
        self.bit_array = array.array('B', [0] * math.ceil(size/8))
        self._lock = Lock()

    def add(self, value: any):
        """
        Record the existence of the given value in the Bloom filter.
        :param value: Value to add the record of existence for in the bloom filter.
        """
        with self._lock:
            for index in self._get_indices(value):
                self.bit_array[index // 8] |= 1 << (index % 8)

    def __contains__(self, value: any) -> bool:
        """
        Override the contains method to check for existence of the given value in the bloom filter.
        :param value: The value to make the existence check for
        :return: True if the value exists otherwise return false
        """
        for index in self._get_indices(value):
            if not (self.bit_array[index // 8] & (1 << index % 8)):
                return False
        return True

    def _get_indices(self, value) -> List[int]:
        """
        Get the indices for a given value. The number of indices are equivalent to the number of hashes used in the
        bloom filter
        :param value: The value to check existence in the bloom filter.
        :return: A list of indices in the bloom filter.
        """
        indices = []
        for seed in range(self.hashes):
            value_hash = hashlib.sha256(str(value).encode() + str(seed).encode()).digest()
            indices.append(int.from_bytes(value_hash, byteorder='big') % self.size)
        return indices
