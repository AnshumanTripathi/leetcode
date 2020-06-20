import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of products, a featured product is called most occuring product in the list.
 * If two products occur same times, then return the most recent product.
 */
public class FeaturedProducts {
  public static void main(String[] args) {
    String[] products = {"yellowShirt","redHat","blackShirt","bluePants", "redHat", "pinkHat", "blackShirt", "yellowShirt", "greenPants", "greenPants"};
    featuredProduct(Arrays.asList(products));
  }

  public static String featuredProduct(List<String> products) {
    Map<String, Integer> productMap = new LinkedHashMap<>();
    for (String product : products) {
      if (!productMap.containsKey(product)) {
        productMap.put(product, 0);
      }
      productMap.put(product, productMap.get(product) + 1);
    }

    LinkedHashMap<String, Integer> featured = new LinkedHashMap<>();
    productMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(prod -> featured.put(prod.getKey(), prod.getValue()));

    return featured.entrySet().iterator().next().getKey();
  }

}
