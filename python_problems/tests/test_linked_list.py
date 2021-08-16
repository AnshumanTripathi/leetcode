from python_problems.data_structures.linked_list import LinkedList


def test_linked_list_crud():
    linked_list = LinkedList()

    linked_list.add(1)
    linked_list.add(2)
    assert len(linked_list.get_linked_list()) != 0
    assert linked_list.get_linked_list() == [2, 1]

    # Add "hello" at index 1
    linked_list.add("hello", 1)

    assert linked_list.get_linked_list() == [2, "hello", 1]

    # Add "world" at the end of the linked list
    linked_list.add("world", -1)
    assert linked_list.get_linked_list() == [2, "hello", 1, "world"]
