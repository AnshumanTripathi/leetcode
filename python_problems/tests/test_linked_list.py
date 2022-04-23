from python_problems.data_structures.linked_list import LinkedList, sort, get_cycle_start, remove_alternate_elements


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


def test_linked_list_sort():
    linked_list = LinkedList()
    linked_list.add(5)
    linked_list.add(3)
    linked_list.add(1)
    linked_list.add(2)

    expected_list = []
    expected_list.append(1)
    expected_list.append(2)
    expected_list.append(3)
    expected_list.append(5)

    sorted_list = sort(linked_list)

    assert sorted_list.get_linked_list() == expected_list


def test_linked_list_cycle():
    node1 = LinkedList.Node(1)
    node2 = LinkedList.Node(2)
    node3 = LinkedList.Node(3)
    node4 = LinkedList.Node(4)

    # Loop the list
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2

    assert get_cycle_start(LinkedList(node1)) == node2


def test_remove_alternate_elements():
    test_linked_list = LinkedList()
    test_linked_list.add(1)
    test_linked_list.add(2)
    test_linked_list.add(3)
    test_linked_list.add(4)
    test_linked_list.add(5)

    remove_alternate_elements(test_linked_list)

    print(test_linked_list)
