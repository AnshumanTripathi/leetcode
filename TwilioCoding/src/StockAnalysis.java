import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StockAnalysis {
  public static void main(String[] args) {

  }

  public static List<String> computeParameterValue(List<List<String>> sources) {
    final Map<String, String> mapping = new LinkedHashMap<>();

    for (List<String> source : sources) {
      for (String kv : source) {
        mapping.put(kv.split(":")[0], kv.split(":")[1]);
      }
    }

    final List<String> results = new ArrayList<>();
    mapping.forEach((k, v) -> results.add(mapping.get(k)));
    return results;
  }
}
