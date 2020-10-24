from python_problems import git_bisect

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


def test_git_bisect():
    assert git_bisect.bisect(commit_log) == "tg4459g"
