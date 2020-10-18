package datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
  private TreeNode root;

  public void add(int value) {
    add(new TreeNode(value));
  }

  public void add(TreeNode node) {
    if (root == null) {
      this.root = node;
      return;
    }

    TreeNode tempNode = root;
    TreeNode parent = root;
    while (tempNode != null) {
      parent = tempNode;
      if (node.getValue() < tempNode.getValue()) {
        tempNode = tempNode.getLeftChild();
      } else {
        tempNode = tempNode.getRightChild();
      }
    }
    if (node.getValue() < parent.getValue()) {
      parent.setLeftChild(node);
      return;
    }
    parent.setRightChild(node);
  }

  public void printInorder() {
    List<TreeNode> nodes = new ArrayList<>();
    inOrder(root, nodes);
    nodes.forEach(node -> System.out.println(node.getValue()));
  }

  public void preOrder() {
    preOrder(root);
  }

  public void postOrder() {
    postOrder(root);
  }

  public void postOrder(TreeNode node) {
    if (node == null) {
      return;
    }
    postOrder(node.getLeftChild());
    postOrder(node.getRightChild());
    System.out.println(node.getValue());
  }

  public void preOrder(TreeNode node) {
    if (node == null) {
      return;
    }
    System.out.println(node.getValue());
    preOrder(node.getLeftChild());
    preOrder(node.getRightChild());
  }

  public void inOrder(TreeNode node, List<TreeNode> nodes) {
    if (node == null) {
      return;
    }
    inOrder(node.getLeftChild(), nodes);
    nodes.add(node);
    inOrder(node.getRightChild(), nodes);
  }

  public void delete(int value) {
    delete(new TreeNode(value));
  }

  public void delete(TreeNode node) {
    TreeNode tempNode = root;
    TreeNode parent = root;
    boolean isLeft = false;

    while (tempNode != null && tempNode.getValue() != node.getValue()) {
      parent = tempNode;
      if (node.getValue() < tempNode.getValue()) {
        tempNode = tempNode.getLeftChild();
        isLeft = true;
      } else {
        tempNode = tempNode.getRightChild();
        isLeft = false;
      }
    }

    if (tempNode == null || tempNode.getValue() != node.getValue()) {
      // Value not found in tree
      return;
    }
    if (!tempNode.hasChildren()) {
      // Node to remove is the leaf node. Just delete the leaf node
      if (isLeft) {
        parent.setLeftChild(null);
      } else {
        parent.setRightChild(null);
      }
    } else if (tempNode.getLeftChild() == null) {
      // If temp Node has no left child,
      if (tempNode.equals(root)) {
        root = tempNode.getRightChild();
      } else {
        if (isLeft) {
          parent.setLeftChild(tempNode.getRightChild());
        } else {
          parent.setRightChild(tempNode.getRightChild());
        }
      }
    } else if (tempNode.getRightChild() == null) {
      if (tempNode.equals(root)) {
        root = tempNode.getLeftChild();
      } else {
        if (isLeft) {
          parent.setLeftChild(tempNode.getLeftChild());
        } else {
          parent.setRightChild(tempNode.getLeftChild());
        }
      }
    } else {
      TreeNode replaceNode = getInorderSuccessor(tempNode);
      if (tempNode.equals(root)) {
        root = replaceNode;
      }
      if (isLeft) {
        parent.setLeftChild(replaceNode);
      } else {
        parent.setRightChild(replaceNode);
      }
      replaceNode.setLeftChild(tempNode.getLeftChild());
    }
  }

  public TreeNode getInorderSuccessor(TreeNode node) {
    if (node.getRightChild() == null) {
      TreeNode temp = root;
      while (temp.hasChildren()) {
        if (node.getValue() < temp.getValue()) {
          temp = temp.getLeftChild();
        } else {
          temp = temp.getRightChild();
        }
      }
      return temp;
    } else {
      TreeNode temp = node.getRightChild();
      while (temp.getLeftChild() != null) {
        temp = temp.getLeftChild();
      }
      return temp;
    }
  }

  public void balance() {
    List<TreeNode> nodes = new ArrayList<>();
    inOrder(root, nodes);
    setRoot(buildTree(nodes, 0, nodes.size() - 1));
  }

  private TreeNode buildTree(List<TreeNode> nodes, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode midNode = nodes.get(mid);
    midNode.setLeftChild(buildTree(nodes, start, mid - 1));
    midNode.setRightChild(buildTree(nodes, mid + 1, end));
    return midNode;
  }

  public void printBfs() {
    List<TreeNode> nodes = bfs(root);
    nodes.forEach(node -> System.out.println(node.getValue()));
  }


  public List<TreeNode> bfs(TreeNode node) {
    List<TreeNode> nodes = new ArrayList<>();
    Queue<TreeNode> nodeq = new LinkedList<>();
    nodeq.add(node);
    while(!nodeq.isEmpty()) {
      TreeNode head = nodeq.poll();
      nodes.add(head);
      if (head.getLeftChild() != null) {
        nodeq.add(head.getLeftChild());
      }
      if (head.getRightChild() != null) {
        nodeq.add(head.getRightChild());
      }
    }
    return nodes;
  }

  public void setRoot(TreeNode root) {
    this.root = root;
  }
}
