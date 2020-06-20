package problems;

public class WaterJugProblem {
  public boolean canMeasureWater(int x, int y, int z) {
    if (x + y < z) {
      return false;
    }
    if (x == z || y == z || x + y == z) {
      return true;
    }

    return z % gcd(x, y) == 0;
  }

  public int gcd(int x, int y) {
    if ( y == 0) {
      return x;
    }
    return gcd(y, x % y);
  }

  public static void main(String[] args) {
    WaterJugProblem wjp = new WaterJugProblem();
    System.out.println(wjp.canMeasureWater(3,5,4));
    System.out.println(wjp.canMeasureWater(2,6,5));
  }
}
