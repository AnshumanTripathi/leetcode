package datastructures.map;

public class Runner {
  public static void main(String[] args) {
    MyMap<Integer, String> myMap = new MyMap<>(1);

    myMap.add(1, "Anshuman");
    myMap.add(2, "Manali");
    myMap.add(3, "Ashutosh");
    myMap.add(3, "Baba");

    System.out.println(myMap.get(1));
    System.out.println(myMap.get(2));
    myMap.remove(3);
    myMap.remove(1);
    System.out.println(myMap.get(3));
    System.out.println(myMap.get(2));
    System.out.println(myMap.get(1));

  }
}
