package datastructures.cache.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  Map<Integer, Node> cacheMap= new HashMap<>();
  Node head;
  Node tail;
  int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public void put(int key, int value) {
    if (cacheMap.containsKey(key)) {
      Node curr = cacheMap.get(key);
      remove(curr);
      curr.value = value;
      add(curr);
    } else {
      Node curr = new Node(key, value);
      if (cacheMap.size() >= this.capacity) {
        cacheMap.remove(tail.previous.key);
        remove(tail.previous);
      }
      add(curr);
      cacheMap.put(key, curr);
    }
  }

  public int get(int key) {
    if (cacheMap.containsKey(key)) {
      remove(cacheMap.get(key));
      add(cacheMap.get(key));
      return cacheMap.get(key).value;
    }
    return -1;
  }

  private void add(Node node) {
    if (head == null && tail == null) {
      head = node;
      tail = node;
    } else {
      if (head != null) {
        head.previous = node;
        node.next = head;
        head = node;
      }
    }
  }

  private void remove(Node node) {
    if (node.previous != null) {
      node.previous.next = node.next;
    } else {
      head = node.next;
    }
    if (node.next != null) {
      node.next.previous = node.previous;
    } else {
      tail = node.previous;
    }
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(3);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    cache.put(4, 4);
    System.out.println(cache.get(4));
    System.out.println(cache.get(3));
    System.out.println(cache.get(2));
    System.out.println(cache.get(1));
    cache.put(5, 5);
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));
    System.out.println(cache.get(5));

  }
}


class Node {
  int key;
  int value;
  Node next;
  Node previous;

  public Node(int key, int value) {
    this.key = key;
    this.value = value;
  }
}