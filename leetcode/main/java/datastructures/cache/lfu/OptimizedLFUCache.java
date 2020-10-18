package datastructures.cache.lfu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class OptimizedLFUCache {
  class Node {
    int key;
    int value;
    int frequency;

    Node next;
    Node prev;

    public Node(int key, int value, int frequency) {
      this.key = key;
      this.value = value;
      this.frequency = frequency;
    }

    public int getKey() {
      return key;
    }

    public int getValue() {
      return value;
    }

    public int getFrequency() {
      return frequency;
    }

    public void setFrequency(int frequency) {
      this.frequency = frequency;
    }

    public Node getNext() {
      return next;
    }

    public Node getPrev() {
      return prev;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    public void setPrev(Node prev) {
      this.prev = prev;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Node node = (Node) o;

      return key == node.key;
    }

    @Override
    public int hashCode() {
      return Objects.hash(key);
    }
  }

  class DList {
    Node head;
    Node tail;

    public DList() {
      this.head = null;
      this.tail = null;
    }

    public void add(Node n) {
      if (head == null && tail == null) {
        head = n;
        tail = n;
        return;
      }
      n.setPrev(tail);
      tail.setNext(n);
      tail = n;
    }

    public void remove(Node n) {
      if (n.getPrev() != null) {
        n.getPrev().setNext(n.getNext());
      } else {
        head = n.getNext();
      }
      if (n.getNext() != null) {
        n.getNext().setPrev(n.getPrev());
      } else {
        tail = n.getPrev();
      }
    }

    public Node removeFirst() {
      if (head == null) {
        return null;
      }
      Node currentHead = head;
      if (head.getNext() != null) {
        head = head.getNext();
      }
      head.setPrev(null);
      return currentHead;
    }

    public boolean isEmpty() {
      return head == null && tail == null;
    }
  }

  final Map<Integer, Node> cacheNodes = new HashMap<>();
  final Map<Integer, DList> frequencies = new LinkedHashMap<>();
  final int capacity;
  int smallest;

  public OptimizedLFUCache(int capacity) {
    this.capacity = capacity;
    this.smallest = 1;
  }

  public void put(int key, int value) {
    if (capacity <= 0) {
      return;
    }
    if (!cacheNodes.containsKey(key)) {
      final Node newNode = new Node(key, value, 1);
      cacheNodes.put(key, newNode);
      frequencies.computeIfAbsent(1, dList -> new DList());
      frequencies.get(1).add(newNode);
      if (isFull()) {
        DList list = frequencies.get(smallest);
        Node removedNode = list.removeFirst();
        cacheNodes.remove(removedNode.getKey());
      }
      smallest = 1;
    } else {
      final Node node = cacheNodes.get(key);
      int nodeFrequency = node.getFrequency();
      frequencies.get(nodeFrequency).remove(node);
      if (nodeFrequency == smallest && frequencies.get(smallest).isEmpty()) {
        smallest = nodeFrequency + 1;
      }
      nodeFrequency += 1;
      node.setFrequency(nodeFrequency);
      Node newNode = new Node(key, value, nodeFrequency);
      frequencies.computeIfAbsent(nodeFrequency, dList -> new DList());
      frequencies.get(nodeFrequency).add(newNode);
      cacheNodes.put(key, newNode);
    }
  }

  public int get(int key) {
    Node node = cacheNodes.get(key);
    if (node == null) {
      return -1;
    }
    frequencies.get(node.getFrequency()).remove(node);
    if (node.getFrequency() == smallest && frequencies.get(smallest).isEmpty()) {
      smallest = node.getFrequency() + 1;
    }
    int nodeFrequency = node.getFrequency() + 1;
    node.setFrequency(nodeFrequency);
    frequencies.computeIfAbsent(nodeFrequency, dList -> new DList());
    Node newNode = new Node(key, node.getValue(), nodeFrequency);
    frequencies.get(nodeFrequency).add(newNode);
    return node.getValue();
  }

  public boolean isFull() {
    return capacity < cacheNodes.size();
  }

  public static void main(String[] args) {
    OptimizedLFUCache cache = new OptimizedLFUCache(1);
    cache.put(2,1);
    System.out.println(cache.get(2));
    cache.put(3,2);
    System.out.println(cache.get(2));
    System.out.println(cache.get(3));


//    System.out.println(cache.get(2));
//    cache.put(2,6);
//    System.out.println(cache.get(1));
//    cache.put(1,5);
//    cache.put(1,2);
//    System.out.println(cache.get(1));
//    System.out.println(cache.get(2));
//    System.out.println();
//
//    cache = new OptimizedLFUCache(2);
//    cache.put(2,1);
//    cache.put(2,2);
//    System.out.println(cache.get(2));
//    cache.put(1,1);
//    cache.put(4,1);
//    System.out.println(cache.get(2));
//    System.out.println();
//
//    cache = new OptimizedLFUCache(2);
//    cache.put(2, 1);
//    cache.put(3, 2);
//    System.out.println(cache.get(3));
//    System.out.println(cache.get(2));
//    cache.put(4, 3);
//    System.out.println(cache.get(2));
//    System.out.println(cache.get(3));
//    System.out.println(cache.get(4));
//    System.out.println();
//
//    cache = new OptimizedLFUCache(2);
//    cache.put(1, 1);
//    cache.put(2, 2);
//    System.out.println(cache.get(1));       // returns 1
//    cache.put(3, 3);    // evicts key 2
//    System.out.println(cache.get(2));       // returns -1 (not found)
//    System.out.println(cache.get(3));       // returns 3.
//    cache.put(4, 4);    // evicts key 1.
//    System.out.println(cache.get(1));       // returns -1 (not found)
//    System.out.println(cache.get(3));       // returns 3
//    System.out.println(cache.get(4));       // returns 4
//    System.out.println();
//
//    cache = new OptimizedLFUCache(2);
//    cache.put(3,1);
//    cache.put(2,1);
//    cache.put(2,2);
//    cache.put(4,4);
//    System.out.println(cache.get(2));
//    System.out.println();
//
//    OptimizedLFUCache zeroCache = new OptimizedLFUCache(0);
//    zeroCache.put(0,0);
//    System.out.println(zeroCache.get(0));
  }
}
