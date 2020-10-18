package problems;

import java.util.HashMap;
import java.util.Map;

public class AnagramMappings {

  public static int[] anagramMappings(int[] A, int[] B) {
    Map<Integer, Integer> aMap = new HashMap<>();

    for (int i = 0; i < B.length; i++) {
      aMap.put(B[i], i);
    }

    int[] result = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      result[i] = aMap.get(A[i]);
    }

    return result;
  }
}
