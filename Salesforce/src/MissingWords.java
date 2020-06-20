import java.util.ArrayList;
import java.util.List;

public class MissingWords {
  /**
   * Given two strings separated by white spaces, find the missing words from s which are present in t
   */
  public List<String> missingWords(String t, String s) {
    String[] sArray = s.split(" ");
    String[] tArray = t.split(" ");

    List<String> result = new ArrayList<>();
    int i =0;
    int j = 0;
    while (i < sArray.length) {
      if (j >= tArray.length) {
        break;
      }
      if (!sArray[i].equals(tArray[j])) {
        result.add(sArray[i]);
        i++;
      } else {
        j++;
      }
    }
    if (i < sArray.length) {
      while (i < sArray.length) {
        result.add(sArray[i]);
        i++;
      }
    }
    return result;
  }
}
