package datastructures.binarysearchtree;

public class UniValueSubtree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);

    TreeNode left1 = new TreeNode(1);
    TreeNode left12 = new TreeNode(5);
    TreeNode right12 = new TreeNode(5);
    left1.left = left12;
    left1.right = right12;
    root.left = left1;

    TreeNode right1 = new TreeNode(5);
    TreeNode r1 = new TreeNode(5);
    right1.right = r1;
    root.right = right1;

    System.out.println(countUnivalSubtrees(root));
  }
  static int count = 0;
  public static int countUnivalSubtrees(TreeNode root) {
    isUnival(root);
    return count;
  }

  public static boolean isUnival(TreeNode node) {
    if (node.left == null && node.right == null) {
      count++;
      return true;
    }
    boolean isUnival = true;
    if (node.left != null) {
      isUnival = isUnival(node.left) && isUnival && node.val == node.left.val;
    }

    if (node.right != null) {
      isUnival = isUnival(node.right) && isUnival && node.val == node.right.val;
    }

    if (!isUnival) {
      return false;
    }
    count++;
    return true;
  }

  public static boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}