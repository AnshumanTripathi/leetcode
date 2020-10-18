package datastructures.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
  Map<String, TreeMap<Integer, String>> timeMap = new HashMap<>();

  public TimeMap() {
  }

  public void set(String key, String value, int timestamp) {
    if (!timeMap.containsKey(key)) {
      timeMap.put(key, new TreeMap<>());
    }

    timeMap.get(key).put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    if (!timeMap.containsKey(key)) {
      return "";
    }
    Integer ts = timeMap.get(key).floorKey(timestamp);
    if (ts == null) {
      return "";
    }
    return timeMap.get(key).get(ts);
  }

  public static void main(String[] args) {
    TimeMap map = new TimeMap();
    map.set("love", "high", 10);
    map.set("love", "low", 20);
    System.out.println(map.get("love", 5));
    System.out.println(map.get("love", 10));
    System.out.println(map.get("love", 15));
    System.out.println(map.get("love", 20));
    System.out.println(map.get("love", 25));
    System.out.println(map.get("foo", 5));

  }
}