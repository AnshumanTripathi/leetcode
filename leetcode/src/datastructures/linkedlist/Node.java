package datastructures.linkedlist;

import java.util.Objects;

public class Node<T> {
  private final T value;
  private Node<T> next;

  public Node(final T value) {
    this.value = value;
    this.next = null;
  }

  public Node<T> next(Node<T> node) {
    this.next = node;
    return this;
  }

  public T getValue() {
    return value;
  }

  public Node<T> getNext() {
    return next;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Node<?> node = (Node<?>) o;

    return value.equals(node.value);
  }

  @Override
  public String toString() {
    return value.toString();
  }
}
