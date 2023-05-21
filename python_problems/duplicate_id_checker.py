from typing import List
import hashlib
from threading import Lock


class ProbabilisticDuplicateChecker:
    def __init__(self, size, hashes):
        """
        Use bloom filter for a probabilistic check for duplicates
        :param size: initial size of the bloom filter
        :param hashes: Number of hashes used in the filter
        """
        self.size = size
        self.hashes = hashes
        self.bit_array = [False] * size
        self._lock = Lock()
        self._lookup_set = set()

    def add(self, value: any):
        """
        Record the existence of the given value in the Bloom filter.
        :param value: Value to add the record of existence for in the bloom filter.
        """
        with self._lock:
            for index in self._get_indices(value):
                self.bit_array[index] = True
                self._lookup_set.add(index)

    def __contains__(self, value: any) -> bool:
        """
        Override the contains method to check for existence of the given value in the bloom filter.
        :param value: The value to make the existence check for
        :return: True if the value exists otherwise return false
        """
        for index in self._get_indices(value):
            return index in self._lookup_set

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
