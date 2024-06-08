package com.practice.leetcode.solutions;

import com.practice.leetcode.solutions.linkedlist.ListNode;

public class LinkedListSolutions {
  /**
   * @param list1
   * @param list2
   * @return [1, 2, 4] and [1,3,4]
   * @solution [1, 1, 2, 3, 4, 4]
   */

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode finalList = new ListNode(0);
    ListNode curr = finalList;
    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        curr.next = list1;
        list1 = list1.next;
      } else {
        curr.next = list2;
        list2 = list2.next;
      }
      curr = curr.next;
    }
    if (list1 != null) {
      curr.next = list1;
    } else if (list2 != null) {
      curr.next = list2;
    }
    System.out.println(curr);
    return finalList.next;
  }


  /**
   * @param head
   * @return Problem 83: remove duplicates from sorted list
   * @Input [1, 1, 2, 3, 3, 4, 4, 4]
   * @Solution [1, 2, 3, 4]
   */
  public static ListNode deleteDuplicates(ListNode head) {
    ListNode finalNode = head;
    ListNode curr = finalNode;
    while (head != null) {
      if (curr.val == head.val) {
        head = head.next;
      } else {
        curr.next = new ListNode(head.val, null);
        curr = curr.next;
      }
    }
    return finalNode.next;
  }

  /**
   * @param head
   * @return Problem 83: remove duplicates from sorted list
   * @Input [1, 1, 2, 3, 3, 4, 4, 4]
   * @Solution [1, 2, 3, 4]
   */
  public static ListNode deleteDuplicatesBetterApproach(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
      if (current.val == current.next.val) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
    return head;
  }

  /**
   * @param l1
   * @param l2
   * @return Problem:2 Add Two Numbers
   * @Input [2, 4, 3] & [5,6,4]
   * @Solution [7, 0, 8]
   */
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode finalList = new ListNode(0);
    ListNode temp = finalList;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int sum = carry;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      carry = (sum / 10) % 10;
      temp.next = new ListNode(sum % 10);
      temp = temp.next;
    }
    if (carry > 0) {
      temp.next = new ListNode(carry);
    }
    return finalList.next;
  }

  /**
   * @param head
   * @param n
   * @return Problem:19 remove Nth Node from end of the list
   * @Input head=[1,2,3,4,5], n=2
   * @Solution [1, 2, 3, 5]
   */
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode temp = new ListNode(0);
    temp.next = head;
    ListNode p1 = temp;
    ListNode p2 = temp;
    for (int i = 0; i <= n; i++) {
      p1 = p1.next;
    }
    while (p1 != null) {
      p2 = p2.next;
      p1 = p1.next;
    }
    p2.next = p2.next.next;
    return temp.next;
  }

  /**
   * @param node
   * @return Problem: 237 Delete a node
   */
  public static void deleteNode(ListNode node) {
    ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
    ListNode current = head;
    while (head.next != null) {
      System.out.println(head.val);
      if (current.next.val == node.val) {
        current.next = head.next.next;
      }
      current = head.next;
    }
    current.show();
  }
}

