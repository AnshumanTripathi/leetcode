package problems;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder {

  // max queue is always larger or equal to min queue
  PriorityQueue<Integer> min = new PriorityQueue<>();
  PriorityQueue<Integer> max = new PriorityQueue<>(1000, Collections.reverseOrder());
  // Adds a number into the data structure.
  public void addNum(int num) {
    max.offer(num);
    min.offer(max.poll());
    if (max.size() < min.size()){
      max.offer(min.poll());
    }
  }

  // Returns the median of current data stream
  public double findMedian() {
    if (max.isEmpty() && min.isEmpty()) {
      return 0;
    }
    if (max.size() == min.size()) {
      return (max.peek() + min.peek()) /  2.0;
    } else {
      if (max.peek() == null) {
        return 0.0;
      }
      return max.peek();
    }
  }
}
