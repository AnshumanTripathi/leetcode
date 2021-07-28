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

    def add(self, value):
        node = Node(value)
        if not self.head:
            # If there the list is empty set the new node as the head
            self.head = node
            return
        else:
            node.next = self.head
            self.head = node

    def get_linked_list(self):
        output = []
        node = self.head
        while node is not None:
            output.append(node.value)
            node = node.next
        return output
