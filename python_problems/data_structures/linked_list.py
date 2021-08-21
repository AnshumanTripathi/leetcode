from dataclasses import dataclass


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
        self.length: int = 0

    def add(self, value, pos=None):
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

    def remove(self, pos):
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
