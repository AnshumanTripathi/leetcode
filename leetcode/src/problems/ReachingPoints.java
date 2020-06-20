package problems;

import java.util.HashSet;
import java.util.Set;

public class ReachingPoints {

  public static void main(String[] args) {
//    System.out.println(reachingPoints(1,1,2,2));
    System.out.println(reachingPointsOptimized(1,2,1000000000,2));
    System.out.println(reachingPoints(1,2,1000000000,2));
//    System.out.println(reachingPointsDynamic(1,1,2,2));
//    System.out.println(reachingPointsDynamic(1,1,3,5));
//    System.out.println(reachingPointsIterative(1,1,2,2));
//    System.out.println(reachingPointsIterative(1,1,3,5));
  }

  /**
   * Time complexity O(log(max(tx, ty)))
   * Space complexity O(1)
   */
  public static boolean reachingPointsOptimized(int sx, int sy, int tx, int ty) {
    if (sx == tx && sy == ty) {
      return true;
    }
    if (sx > tx || sy > ty) {
      return false;
    }

    if (tx == sx) {
      // Next point is ty - sy. If that point is divisible tx then we consider it as a reaching point
      return (ty - sy) % tx == 0;
    }
    if (ty == sy) {
      return (tx - sx) % ty == 0;
    }
    return reachingPointsOptimized(sx, sy, tx - ty, ty) || reachingPointsOptimized(sx, sy, tx, ty - tx);
  }

  /**
   * Time complexity O(2^(tx+ty))
   * Space complexity O(tx*ty)
   */
  public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
    if (tx == sx && ty == sy) {
      return true;
    }
    if (tx > sx || ty > sy) {
      return false;
    }

    return reachingPoints(sx + sy, sy, tx, ty) || reachingPoints(sx, sx+ sy, tx, ty);
  }

  /**
   * Time Complexity O(tx*ty)
   * Space Complexity O(tx*ty)
   */
  public static boolean reachingPointsDynamic(int sx, int sy, int tx, int ty) {
    Set<Point> seen = new HashSet<>();
    Point sourcePoint = new Point(sx, sy);
    search(sourcePoint, seen, tx, ty);
    return seen.contains(new Point(tx, ty));
  }

  public static boolean reachingPointsIterative(int sx, int sy, int tx, int ty) {
    while (tx >= sx && ty >= sy) {
      if (sx == tx && sy == ty) {
       return true;
      }
      if (tx > ty) { // Because coordinates cannot be negative
        tx -= ty;
      } else {
        ty -= tx;
      }
    }
    return false;
  }

  public static void search(Point point, Set<Point> points, int tx, int ty) {
    if (points.contains(point)) {
      return;
    }
    if (point.getX() > tx || point.getY() > ty) {
      return;
    }
    points.add(point);
    search(new Point(point.getX() + point.getY(), point.getY()), points, tx, ty);
    search(new Point(point.getX(), point.getX() + point.getY()), points, tx, ty);
  }

  static class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Point point = (Point) o;

      if (x != point.x) return false;
      return y == point.y;
    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }
  }
}
