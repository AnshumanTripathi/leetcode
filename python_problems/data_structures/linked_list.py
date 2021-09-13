from dataclasses import dataclass
from copy import deepcopy
from typing import Optional


class LinkedList:
    # https://docs.python.org/3/library/dataclasses.html
    @dataclass
    class Node:
        """
        A single node of the linked list containing a value and holding the next node
       """
        value: int
        next: object = None

        def __hash__(self) -> int:
            return hash(self.value)

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
        if not node.next:
            return 1

        length = 0
        slow = node
        fast = node
        start = 0  # A flag to show that we are at the start of the linked list
        loop_start = None

        while fast.next and fast.next.next:
            if slow == fast and start != 0:
                # There is a loop in the linked list
                loop_start = slow.next
                length = 1
                slow = slow.next
                while slow != fast:
                    slow = slow.next
                    length = length + 1
                break

            slow = slow.next
            fast = fast.next.next
            start = 1
        if start == 1 and length == 0:
            # There was no loop in the list
            temp = node
            while temp.next is not None:
                length += 1
                temp = temp.next
        elif start == 1:
            # There was a loop in the liked list. `length` should contain the length of the loop. Now we need to find
            # the length of the list from the `head` node to the starting of the loop i.e. `loop_start` node.
            temp = node
            while temp != loop_start:
                length += 1
                temp = temp.next
        return length

    def add(self, value, pos: int = None):
        """
        Add the given value to the LinkedList. By default a new value is added at the starting of the list.
        :param value: Value to be added
        :param pos: If this parameter is provided, add the node on the the specific position. All remaining nodes after
                    provided position are shifted by one. The starting index of the linked list is 0 (zero).
        """
        node = self.Node(value)
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

    def __hash__(self) -> int:
        return hash(self.head.value)

    def __eq__(self, other: object) -> bool:
        if isinstance(other, LinkedList):
            return self.get_linked_list() == other.get_linked_list()
        return False

    def __ne__(self, other: object) -> bool:
        if isinstance(other, LinkedList):
            return self.get_linked_list() != other.get_linked_list()
        return False

    def __str__(self) -> str:
        return "->".join(str(self.get_linked_list()))

    def __repr__(self) -> str:
        return f"LinkedList({self.head.value})"


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


def _sort(node: LinkedList.Node) -> LinkedList.Node:
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

    mid_node: LinkedList.Node = _get_middle_node(node)
    mid_next: LinkedList.Node = mid_node.next

    mid_node.next = None
    left_list = _sort(node)
    right_list = _sort(mid_next)

    return _merge_sort(left_list, right_list)


def _merge_sort(left_list: LinkedList.Node, right_list: LinkedList.Node) -> LinkedList.Node:
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


def _get_middle_node(node: LinkedList.Node) -> LinkedList.Node:
    """
    Get the middle node of the list using Flyod's approach
    :param node: Starting node
    :return: The middle node
    """
    if not node:
        raise Exception('Cannot get middle for `None` node.')

    if not node.next:
        return node

    slow: LinkedList.Node = node
    fast: LinkedList.Node = node

    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next

    return slow


def get_cycle_start(linked_list: LinkedList) -> Optional[LinkedList.Node]:
    """
    If the linked list has
    :param linked_list:
    :return:
    """

    slow_node = linked_list.head
    fast_node = linked_list.head

    while fast_node.next and fast_node.next.next:
        slow_node = slow_node.next
        fast_node = fast_node.next.next

        if fast_node == slow_node:
            break

    if slow_node != fast_node:
        # There is no loop
        return None

    slow_node = linked_list.head

    while slow_node != fast_node:
        slow_node = slow_node.next
        fast_node = fast_node.next

    return slow_node
