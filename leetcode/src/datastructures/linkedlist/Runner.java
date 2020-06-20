package datastructures.linkedlist;

public class Runner {
  public static void main(String[] args) {
    final LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add("head");
    linkedList.add("this");
    linkedList.add("is");
    linkedList.add("a");
    linkedList.add("linked");
    linkedList.add("list");
    linkedList.add("new node");
    linkedList.foreach(System.out::println);
    System.out.println(linkedList.length());
    System.out.println("-------------------------");
    linkedList.remove("new node");
    linkedList.foreach(System.out::println);
    System.out.println("-------------");
    linkedList.reverse();
    linkedList.foreach(System.out::println);

//    final IntegerList integerIntegerList = new IntegerList();
//
//    integerIntegerList.add(5);
//    integerIntegerList.add(4);
//    integerIntegerList.add(3);
//    integerIntegerList.add(2);
//    integerIntegerList.add(1);
//    integerIntegerList.sort();
//    integerIntegerList.foreach(System.out::println);


  }
}
