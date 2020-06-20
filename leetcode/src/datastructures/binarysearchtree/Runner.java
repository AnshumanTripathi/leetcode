package datastructures.binarysearchtree;

public class Runner {

  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.add(1);
    tree.add(2);
    tree.add(3);
    tree.add(4);
    tree.add(5);
    tree.balance();
    tree.printBfs();
  }

}
