package datastructures.linkedlist;

public class IntegerList extends LinkedList<Integer> {
  public Node<Integer> sort() {
    return sort(this.head);
  }

  // Ref: https://www.geeksforgeeks.org/merge-sort-for-linked-list/
  public Node<Integer> sort(Node<Integer> node) {
    if (node == null || node.getNext() == null) {
      return node;
    }

    // Get the middle node and split the list from the middle
    Node<Integer> midNode = getMiddleNode(node);
    Node<Integer> midNext = midNode.getNext();

    midNode.next(null);

    // Recursively split the left and right lists from the middle
    final Node<Integer> leftList = sort(node);
    final Node<Integer> rightList = sort(midNext);

    // Sort and merge all the divided lists
    return merge(leftList, rightList);
  }

  private Node<Integer> merge(Node<Integer> leftList, Node<Integer> rightList) {
    Node<Integer> sorted = null;
    if (leftList == null) {
      return rightList;
    }
    if (rightList == null) {
      return leftList;
    }

    if (leftList.getValue() <= rightList.getValue()) {
      sorted = leftList;
      sorted.next(merge(leftList.getNext(), rightList));
    } else {
      sorted = rightList;
      sorted.next(merge(leftList, rightList.getNext()));
    }
    return sorted;
  }

  private Node<Integer> getMiddleNode(final Node<Integer> node) {
    if (node == null) {
      return null;
    }

    if (node.getNext() == null) {
      return node;
    }

    Node<Integer> fast = node;
    Node<Integer> slow = node;

    while (fast.getNext() != null && fast.getNext().getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }

    return slow;
  }
}
