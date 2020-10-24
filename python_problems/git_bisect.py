"""
Implement git bisect. Given a dictionary containing commitsh, and a boolean
representing if the commitsh is good. Find the first bad commitsh.
"""


def bisect(log):
    start = 0
    end = len(log)
    while start < end:
        mid = int(start + (end - start) / 2)
        if log[mid].get("good"):
            start = mid + 1
        else:
            end = mid - 1
    return log[start].get("sha")
