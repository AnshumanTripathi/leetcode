package datastructures.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class MyHashMap {
  private List<MapNode> nodes;
  private int numOfBuckets;

  /** Initialize your data structure here. */
  public MyHashMap() {
    this(10);
  }

  public MyHashMap(int size) {
    this.numOfBuckets = size;
    nodes = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      nodes.add(null);
    }
  }

  public int getBucketIndex(int key) {
    int hash = Math.abs(Objects.hash(key));
    return hash % numOfBuckets;
  }

  public int size() {
    int size = 0;
    for (MapNode node : nodes) {
      if (node != null) {
        size++;
      }
    }
    return size;
  }
  /** value will always be non-negative. */
  public void put(int key, int value) {
    int index = getBucketIndex(key);

    MapNode head = this.nodes.get(index);
    MapNode newNode = new MapNode(key, value);
    if (head != null) {
      while (head != null && head.getKey() != key) {
        head = head.getNext();
      }

      if (head == null) {
        newNode.setNext(nodes.get(index));
        nodes.set(index, newNode);
      } else if (head.getKey() == key) {
        head.setValue(value);
      }

    } else {
      this.nodes.set(index, newNode);
    }
  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  public int get(int key) {
    int index = getBucketIndex(key);
    if (index > nodes.size()) {
      return -1;
    }
    MapNode head = nodes.get(index);

    while (head != null) {
      if (head.getKey() == key) {
        return head.getValue();
      }
      head = head.getNext();
    }

    return -1;
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    int index = getBucketIndex(key);
    MapNode node = nodes.get(index);
    if (node == null) {
      return;
    }
    if (node.getNext() == null) {
      // No chained nodes. Just remove from the list
      nodes.set(index, null);
      return;
    }
    MapNode temp = null;
    while(node != null) {
      if (node.getKey() == key) {
        break;
      }
      temp = node;
      node = node.getNext();
    }

    if (node == null) {
      return;
    }
    if (temp == null) {
      // Remove head node
      nodes.set(index, node.getNext());
      numOfBuckets--;
      return;
    }
    numOfBuckets--;
    temp.setNext(node.getNext());
  }
  class MapNode {
    private int key;
    private int value;

    private MapNode next;

    public MapNode() {
    }

    public MapNode(int key, int value) {
      this.key = key;
      this.value = value;
    }

    public int getKey() {
      return key;
    }

    public void setKey(int key) {
      this.key = key;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public MapNode getNext() {
      return next;
    }

    public void setNext(MapNode next) {
      this.next = next;
    }
  }

  public static void main(String[] args) {
    MyHashMap map = new MyHashMap();
    map.remove(14);
  }
}
