from python_problems.data_structures.linked_list import LinkedList


def test_linked_list():
    linked_list = LinkedList()
    linked_list.add(1)
    linked_list.add(2)
    assert len(linked_list.get_linked_list()) != 0
    assert linked_list.get_linked_list() == [2, 1]
