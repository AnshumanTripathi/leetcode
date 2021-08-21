package datastructures.linkedlist;

import java.util.function.Consumer;

public class LinkedList<T> {
  protected Node<T> head;
  protected Node<T> tail;
  protected long length = 0;

  public LinkedList() {
  }

  public LinkedList(T value) {
      head = new Node<>(value);
      tail = head;
  }

  /**
   * Add a element to the linked list
   * @param value value to be added
   */
  public void add(final T value) {
    final Node<T> node = new Node<>(value);
    if (head == null && tail == null) {
      head = node;
    } else {
      tail.next(node);
    }
    tail = node;
  }

  /**
   * Add an element at the index in the linked list
   * @param index index where the element is to be added
   * @param value value to be added
   */
  public void add(final int index, final T value) {
    final Node<T> nodeToAdd = new Node<>(value);
    if (index == 0) {
      nodeToAdd.next(head);
      head = nodeToAdd;
      return;
    }
    if (index == length() - 1) {
      tail.next(nodeToAdd);
      tail = nodeToAdd;
      return;
    }
    if (index > length() - 1) {
      throw new IndexOutOfBoundsException();
    }
    Node<T> traverseNode = head.getNext();
    Node<T> prevNode = head;
    int i = 1;
    while (traverseNode != null) {
      if (i == index) {
        prevNode.next(nodeToAdd);
        nodeToAdd.next(traverseNode);
        return;
      }
      prevNode = traverseNode;
      traverseNode = traverseNode.getNext();
      i++;
    }
  }

  public long length() {
    int length = 0;
    Node<T> traverseNode = head;
    while(traverseNode != null) {
      length++;
      traverseNode = traverseNode.getNext();
    }
    return length;
  }

  public void foreach(final Consumer<? super T> consumer) {
    Node<T> node = head;
    while (node != null) {
      consumer.accept(node.getValue());
      node = node.getNext();
    }
  }

  public void remove(final T value) {
    Node<T> node = head;
    Node<T> prev = head;
    if (head.getValue().equals(value)) {
      if (length == 1) {
        head = null;
        length--;
        return;
      }
      head.next(node.getNext());
      node.next(null);
      length--;
      return;
    }
    while (node != null) {
      if (node.getValue().equals(value)) {
        break;
      }
      prev = node;
      node = node.getNext();
    }
    if (node == null) {
      // Reached the end of linked list
      return;
    }
    prev.next(node.getNext());
    length--;
  }

  /**
   * Reverse the linked list
   */
  public void reverse() {
    Node<T> prev = null;
    Node<T> current = this.head;
    Node<T> next = null;

    while(current != null) {
      next = current.getNext();
      current.next(prev);
      prev = current;
      current = next;
    }
    this.head = prev;
  }

}
