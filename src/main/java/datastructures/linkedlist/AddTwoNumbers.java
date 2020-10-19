package datastructures.linkedlist;

public class AddTwoNumbers {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);

  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int sum = 0;
    int carry = 0;
    ListNode result = new ListNode();
    ListNode curr = result;
    while(l1 != null || l2 != null) {
      int p1 = l1 == null ? 0 : l1.val;
      int p2 = l2 == null ? 0 : l2.val;

      sum = p1 + p2 + carry;
      if (sum > 9) {
        carry = 10 - sum;
      }

      curr.next = new ListNode(sum);
      l1 = l1 != null ? l1.next : l1;
      l2 = l2 != null ? l2.next : l2;
      curr = curr.next;
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
    return result.next;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}