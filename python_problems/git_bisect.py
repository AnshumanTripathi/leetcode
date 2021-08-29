"""
Implement git bisect. Given a dictionary containing commitsh, and a boolean
representing if the commitsh is good. Find the first bad commitsh.
"""
from typing import List


def bisect(log: List) -> str:
    if len(log) == 0:
        return ""
    if len(log) == 1:
        return "" if log[0].get("good") else log[0].get("sha")
    start = 0
    end = len(log)
    while start < end:
        mid = int(start + (end - start) / 2)
        if log[mid].get("good"):
            start = mid + 1
        else:
            end = mid - 1

    if log[start].get("good"):
        return ""

    return log[start].get("sha")
