from python_problems.duplicate_id_checker import ProbabilisticDuplicateChecker
import threading
from time import sleep


def test_duplicate_checker():
    duplicate_checker = ProbabilisticDuplicateChecker(100, 3)
    duplicate_checker.add('green')
    duplicate_checker.add('purple')
    duplicate_checker.add('orange')

    assert 'orange' in duplicate_checker


def test_duplicate_multithread():
    duplicate_checker = ProbabilisticDuplicateChecker(100, 3)
    threads = [threading.Thread(target=_exec_check, args=['green', duplicate_checker]),
               threading.Thread(target=_exec_check, args=['purple', duplicate_checker]),
               threading.Thread(target=_exec_check, args=['orange', duplicate_checker])]
    [t.start() for t in threads]
    [t.join() for t in threads]
    assert 'orange' in duplicate_checker


def _exec_check(value, dupe_checker: ProbabilisticDuplicateChecker):
    dupe_checker.add(value)
    sleep(5)

