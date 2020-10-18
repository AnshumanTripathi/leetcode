package datastructures.map;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> {

  private List<MapNode<K, V>> nodes;
  private int numOfBuckets;

  public MyMap() {
    this(10);
  }

  public MyMap(int size) {
    this.numOfBuckets = size;
    nodes = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      nodes.add(null);
    }
  }

  public int getBucketIndex(K key) {
    int hash = Math.abs(key.hashCode());
    return hash % numOfBuckets;
  }

  public void add(final K key, final V value) {
    int index = getBucketIndex(key);

    MapNode<K, V> head = this.nodes.get(index);
    MapNode<K,V> newNode = new MapNode<>(key, value);
    if (head != null) {
      while (head != null && !head.getKey().equals(key)) {
        head = head.getNext();
      }

      if (head == null) {
        newNode.setNext(nodes.get(index));
        nodes.set(index, newNode);
      } else if (head.getKey().equals(key)) {
        head.setValue(value);
      }

    } else {
      this.nodes.set(index, newNode);
    }

    if ((size() * 1.0) / numOfBuckets > 0.75f) {
      List<MapNode<K, V>> temp = nodes;
      this.nodes = new ArrayList<>();
      this.numOfBuckets *= 2;
      for (int i = 0; i < numOfBuckets; i++) {
        nodes.add(null);
      }

      for (MapNode<K, V> node : temp) {
        if (node != null) {
          add(node.getKey(), node.getValue());
        }
      }
    }
  }

  public int size() {
    int size = 0;
    for (MapNode<K, V> node : nodes) {
      if (node != null) {
        size++;
      }
    }
    return size;
  }

  public V get(final K key) {
    int index = getBucketIndex(key);
    if (index > nodes.size()) {
      return null;
    }
    MapNode<K, V> head = nodes.get(index);

    while (head != null) {
      if (head.getKey().equals(key)) {
        return head.getValue();
      }
      head = head.getNext();
    }

    return null;
  }

  public void remove(final K key) {
    int index = getBucketIndex(key);
    MapNode<K,V> node = nodes.get(index);
    if (node.getNext() == null) {
      // No chained nodes. Just remove from the list
      nodes.set(index, null);
      return;
    }
    MapNode<K,V> temp = null;
    while(node != null) {
      if (node.getKey().equals(key)) {
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
}
