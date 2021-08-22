from python_problems.data_structures.linked_list import LinkedList, sort


def test_linked_list_crud():
    linked_list = LinkedList()

    expected_list = []
    linked_list.add(1)
    linked_list.add(2)
    assert linked_list.length != 0
    expected_list.append(2)
    expected_list.append(1)

    assert linked_list.get_linked_list() == expected_list

    # Add 'hello' at index 1
    linked_list.add('hello', 1)

    expected_list.insert(1, 'hello')

    assert linked_list.get_linked_list() == expected_list

    # Add "world" at the end of the linked list
    linked_list.add('world', -1)
    expected_list.insert(len(expected_list), 'world')
    assert linked_list.get_linked_list() == expected_list

    linked_list.remove(-1)
    expected_list.remove('world')
    assert linked_list.get_linked_list() == expected_list

    linked_list.add('world', -1)
    expected_list.insert(len(expected_list), 'world')
    linked_list.remove(2)
    expected_list.remove(1)
    assert linked_list.get_linked_list() == expected_list

    linked_list.clear()

    linked_list.add(5)
    linked_list.add(3)
    linked_list.add(1)
    linked_list.add(2)

    expected_list.clear()
    expected_list.append(1)
    expected_list.append(2)
    expected_list.append(3)
    expected_list.append(5)

    sorted_list = sort(linked_list)

    assert sorted_list.get_linked_list() == expected_list



