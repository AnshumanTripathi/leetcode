package problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
  private Queue<Integer> minPq = new PriorityQueue<>();
  private Queue<Integer> maxPq = new PriorityQueue<>((a1, a2) -> a2 - a1);

  public void addNum(int num) {
    maxPq.offer(num);
    minPq.offer(maxPq.poll());
    if (maxPq.size() < minPq.size()) {
      maxPq.offer(minPq.poll());
    }
  }

  public double findMedian() {
    if (maxPq.size() == minPq.size()) {
      return (maxPq.peek() + minPq.peek()) / 2.0;
    }
    return maxPq.peek();
  }

  public static void main(String[] args) {
    MedianFinder finder = new MedianFinder();
    finder.addNum(1);
    finder.addNum(2);
    System.out.println(finder.findMedian());
    finder.addNum(3);
    System.out.println(finder.findMedian());

//    MedianFinder finder = new MedianFinder();
//    finder.addNum(1);
//    System.out.println(finder.findMedian());

//    MedianFinder finder = new MedianFinder();
//    finder.addNum(2);
//    System.out.println(finder.findMedian());
//    finder.addNum(3);
//    System.out.println(finder.findMedian());

//    MedianFinder finder = new MedianFinder();
//    finder.addNum(-1);
//    System.out.println(finder.findMedian());
//    finder.addNum(-2);
//    System.out.println(finder.findMedian());
//    finder.addNum(-3);
//    System.out.println(finder.findMedian());
//    finder.addNum(-4);
//    System.out.println(finder.findMedian());
//    finder.addNum(-5);
//    System.out.println(finder.findMedian());
  }
}
