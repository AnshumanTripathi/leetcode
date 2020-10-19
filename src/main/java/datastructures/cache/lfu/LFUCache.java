package datastructures.cache.lfu;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LFUCache {
  private final int capacity;
  private final Map<Integer, CacheObject> cacheMap = new LinkedHashMap<>();
  private final List<CacheObject> keys = new LinkedList<>();

  public LFUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    final CacheObject valueObj = cacheMap.get(key);
    if (valueObj == null) {
      return -1;
    }
    valueObj.setFrequency(valueObj.getFrequency() + 1);
    keys.remove(valueObj);
    keys.add(valueObj);
    cacheMap.put(key, valueObj);
    return valueObj.getValue();
  }

  public void put(int key, int value) {
    if (capacity <= 0) {
      return;
    }

    final CacheObject valueObj = new CacheObject(key, value, 1);

    if (cacheMap.containsKey(key)) {
      final CacheObject oldValue = cacheMap.get(key);
      keys.remove(oldValue);
      valueObj.setFrequency(oldValue.getFrequency() + 1);
      addValue(key, valueObj);
      return;
    }

    if(isFull()) {
      keys.sort(Comparator.comparingInt(CacheObject::getFrequency));
      int keyToRemove = keys.remove(0).getKey();
      cacheMap.remove(keyToRemove);
    }
    addValue(key, valueObj);
  }

  public void addValue(int key, CacheObject valueObj) {
    cacheMap.put(key, valueObj);
    keys.add(valueObj);
  }

  public boolean isFull() {
    return cacheMap.size() == capacity;
  }

  class CacheObject {
    int key;
    int value;
    int frequency;

    public CacheObject(int key, int value, int frequency) {
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

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      CacheObject that = (CacheObject) o;

      if (key != that.key) return false;
      if (value != that.value) return false;
      return frequency == that.frequency;
    }

    @Override
    public int hashCode() {
      int result = key;
      result = 31 * result + value;
      result = 31 * result + frequency;
      return result;
    }
  }

  public static void main(String[] args) {
    LFUCache cache = new LFUCache(2);

    System.out.println(cache.get(2));
    cache.put(2,6);
    System.out.println(cache.get(1));
    cache.put(1,5);
    cache.put(1,2);
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));
    System.out.println();

    cache = new LFUCache(2);
    cache.put(2,1);
    cache.put(2,2);
    System.out.println(cache.get(2));
    cache.put(1,1);
    cache.put(4,1);
    System.out.println(cache.get(2));
    System.out.println();

    cache = new LFUCache(2);
    cache.put(2, 1);
    cache.put(3, 2);
    System.out.println(cache.get(3));
    System.out.println(cache.get(2));
    cache.put(4, 3);
    System.out.println(cache.get(2));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));
    System.out.println();

    cache = new LFUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));       // returns 1
    cache.put(3, 3);    // evicts key 2
    System.out.println(cache.get(2));       // returns -1 (not found)
    System.out.println(cache.get(3));       // returns 3.
    cache.put(4, 4);    // evicts key 1.
    System.out.println(cache.get(1));       // returns -1 (not found)
    System.out.println(cache.get(3));       // returns 3
    System.out.println(cache.get(4));       // returns 4
    System.out.println();

    cache = new LFUCache(2);
    cache.put(3,1);
    cache.put(2,1);
    cache.put(2,2);
    cache.put(4,4);
    System.out.println(cache.get(2));
    System.out.println();

    LFUCache zeroCache = new LFUCache(0);
    zeroCache.put(0,0);
    System.out.println(zeroCache.get(0));
  }
}
