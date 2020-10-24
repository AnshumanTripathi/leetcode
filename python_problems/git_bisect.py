"""
Implement git bisect. Given a dictionary containing commitsh, and a boolean
representing if the commitsh is good. Find the first bad commitsh.
"""

commit_log = [
    {"sha": "ae2b456", "good": True},
    {"sha": "cv2450p", "good": True},
    {"sha": "56qdasd", "good": True},
    {"sha": "9isfbs2", "good": True},
    {"sha": "r4278df", "good": True},
    {"sha": "tg4459g", "good": False},
    {"sha": "h7wr0g1", "good": False},
    {"sha": "4g45821", "good": False}
]


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


if __name__ == "__main__":
    print(bisect(commit_log))
