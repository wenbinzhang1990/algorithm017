package com.geek.week1;

public class MergeTwoStoredList {

  public static void main(String[] args) {
    ListNode head1 = new ListNode(1);
    ListNode head2 = new ListNode(1);
    head1.next = new ListNode(2);
    head1.next.next = new ListNode(4);
    head2.next = new ListNode(3);
    head2.next.next = new ListNode(4);
    mergeTwoLists(head1, head2);
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode result = new ListNode();
    ListNode pre = result;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        result.next = l1;
        l1 = l1.next;
      } else {
        result.next = l2;
        l2 = l2.next;
      }

      result = result.next;
    }

    result.next = l1 == null ? l2 : l1;
    return pre.next;
  }


  static class ListNode {

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
}
