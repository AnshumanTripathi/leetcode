package datastructures.linkedlist;

import java.util.Objects;

public class IntegerList extends LinkedList<Integer> {
  public Node<Integer> sort() {
    return sort(this.head);
  }

  public Node<Integer> sort(Node<Integer> node) {
    if (node == null || node.getNext() == null) {
      return node;
    }
    Node<Integer> fast = node;
    Node<Integer> slow = node;
    Node<Integer> temp = node;

    while (fast.getNext() != null && fast.getNext().getNext() != null) {
      temp = slow;
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }
    temp.next(null);
    Node<Integer> leftList = sort(node);
    Node<Integer> rightList = sort(slow);

    return merge(leftList, rightList);
  }

  private Node<Integer> merge(Node<Integer> leftList, Node<Integer> rightList) {
    Node<Integer> sorted = new Node<>(0);
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
    return sorted.getNext();
  }
}
