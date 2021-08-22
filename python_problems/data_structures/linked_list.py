from dataclasses import dataclass
from copy import deepcopy


# https://docs.python.org/3/library/dataclasses.html
@dataclass
class Node:
    """
    A single node of the linked list containing a value and holding the next node
    """
    value: int
    next: object = None


class LinkedList:
    """
    An implementation of a LinkedList.
    """

    def __init__(self, head: Node = None):
        self.head = head
        self.length: int = self._get_length(head)

    @staticmethod
    def _get_length(node: Node) -> int:
        """
        Evaluate the length of the list from the given node
        :param node: The input node object
        :return: length of the list
        """

        if not node:
            return 0

        length = 0
        while node:
            length = length + 1
            node = node.next
        return length

    def add(self, value, pos: int = None):
        """
        Add the given value to the LinkedList. By default a new value is added at the starting of the list.
        :param value: Value to be added
        :param pos: If this parameter is provided, add the node on the the specific position. All remaining nodes after
                    provided position are shifted by one. The starting index of the linked list is 0 (zero).
        """
        node = Node(value)
        if not self.head:
            # If there the list is empty set the new node as the head
            self.head = node
            self.length = self.length + 1
            return
        elif pos is not None:
            i = 0
            prev_node = None
            next_node = self.head
            while pos != i and next_node is not None:
                i = i + 1
                prev_node = next_node
                next_node = next_node.next

            prev_node.next = node
            node.next = next_node
        else:
            node.next = self.head
            self.head = node
        self.length = self.length + 1

    def get_linked_list(self):
        """
        Get the list representation of the linked list
        :return: a list of all the values of the nodes in the linked list. The order of the linked list is preserved.
        """
        output = []
        node = self.head
        while node is not None:
            output.append(node.value)
            node = node.next
        return output

    def remove(self, pos: int):
        """
        Remove an element from the linked list.
        :param pos: Position of the element in the linked list. If the value is less than 0 then, last node of the list
                    is removed
        """
        if self.head is None:
            raise Exception('Cannot remove element from an empty list')

        if pos > self.length:
            raise IndexError('Position of range')

        prev_node = None
        next_node = self.head
        i = 0

        # We want to stop the loop where next_node is the last node and the prev_node is the second to last node.
        # This allows easy removal of the last node the position given is less than 0 or equals to the length of the
        # list
        while i != pos and next_node.next is not None:
            prev_node = next_node
            next_node = next_node.next
            i = i + 1

        if next_node.next is None:
            prev_node.next = None
        else:
            prev_node.next = next_node.next
        self.length = self.length - 1

    def clear(self):
        """
        Empty the list
        """
        self.head = None
        self.length = 0


"""
---------------  Linked List Utility Functions -------------------------
"""


def sort(linked_list: LinkedList) -> LinkedList:
    """
    Sort the Linked list use a merge sort. This is only support for Integer type lists. A mixed typed list will
    raise Exception. The input linked list's head is deep copied. We need to do this because python creates bindings
    between objects, so keep the input list's head pristine, we need to deepcopy the head and sort the nodes of the
    copied head.
    :param linked_list: Sorting a given linked list
    :return: A sorted linked list
    """
    list_head = deepcopy(linked_list.head)
    sorted_head = _sort(list_head)
    return LinkedList(sorted_head)


def _sort(node: Node) -> Node:
    """
    :return: A Node object containing the first element of the list in the naturally sorted order followed by all
    other elements in the naturally sorted order.
    :param node:
    :return: A
    """
    if not node:
        raise Exception('Cannot sort an empty linked list')

    if not node.next:
        return node

    mid_node: Node = _get_middle_node(node)
    mid_next: Node = mid_node.next

    mid_node.next = None
    left_list = _sort(node)
    right_list = _sort(mid_next)

    return _merge_sort(left_list, right_list)


def _merge_sort(left_list: Node, right_list: Node) -> Node:
    if not left_list:
        return right_list

    if not right_list:
        return left_list

    if not isinstance(left_list.value, int) and not isinstance(right_list.value, int):
        raise TypeError('Sorting only supported for integer type lists')

    if left_list.value <= right_list.value:
        result = left_list
        result.next = _merge_sort(left_list.next, right_list)
    else:
        result = right_list
        result.next = _merge_sort(left_list, right_list.next)

    return result


def _get_middle_node(node: Node) -> Node:
    """
    Get the middle node of the list using Flyod's approach
    :param node: Starting node
    :return: The middle node
    """
    if not node:
        raise Exception('Cannot get middle for `None` node.')

    if not node.next:
        return node

    slow: Node = node
    fast: Node = node

    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next

    return slow
