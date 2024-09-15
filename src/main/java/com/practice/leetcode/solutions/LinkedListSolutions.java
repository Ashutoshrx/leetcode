package com.practice.leetcode.solutions;

import com.practice.leetcode.solutions.linkedlist.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

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

  /**
   * @param head
   * @return Problem: 206: Reverse a linked List
   */
  public static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    while (current != null) {
      ListNode nextOfCurrentNode = current.next;
      ListNode temp = prev;
      prev = current;
      prev.next = temp;
      current = nextOfCurrentNode;
    }
    return prev;
  }

  /**
   * @param head
   * @return Problem: 141: Linked List Cycle
   * @ERROR Some test cases are failing
   */
  public static boolean hasCycle(ListNode head) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    ListNode temp = head;
    while (temp != null) {
      hashMap.put(temp.val, hashMap.getOrDefault(temp.val, 0) + 1);
      if (hashMap.get(temp.val) > 1) {
        return true;
      }
      temp = temp.next;
    }
    return false;
  }

  /**
   * @param nums
   * @param head
   * @return Problem: 3217: Delete nodes from linkedList Present in array
   */
  public static ListNode modifiedList(int[] nums, ListNode head) {
    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    ListNode dummy = new ListNode(0, head);
    ListNode curr = head;
    ListNode prev = dummy;
    while (curr != null) {
      if (set.contains(curr.val)) {
        prev.next = curr.next;
      } else {
        prev = prev.next;
      }
      curr = curr.next;
    }
    return dummy.next;
  }

  /**
   * @param head
   * @return Problem: 143 Reorder Lists
   * Not Working
   */
  public static void reorderList(ListNode head) {
    ListNode dummy = new ListNode(0, head);
    ListNode second = dummy.next;
    ListNode curr = head;
    ListNode lastNode;
    while (curr.next != null) {
      System.out.println(curr.val);
      curr = curr.next;
    }
    curr.next = second;
//    curr.next = second;
    dummy.next = curr;
//    head.next=lastNode;
    dummy.show();
  }

  /**
   * @param head
   * @return Problem: 234: Palindrome Linked List
   */
  public static boolean isPalindrome(ListNode head) {
    Stack<Integer> stack = new Stack<>();
    ListNode current = head;
    ListNode temp = head;
    while (current != null) {
      stack.push(current.val);
      current = current.next;
    }
    while (temp != null && temp.val == stack.pop()) {
      temp = temp.next;
    }
    return stack.isEmpty();
  }

  /**
   * @param head
   * @param val
   * @return Problem: 203: Remove linked List elements
   */
  public static ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0, head);
    ListNode previous = dummy;
    ListNode current = head;
    while (current != null) {
      if (val == current.val) {
        previous.next = current.next;
      } else {
        previous = current;
      }
      current = current.next;
    }
    return dummy.next;
  }

  /**
   * @param head
   * @return Problem: 876: Middle of Linked List
   */
  public static ListNode middleNode(ListNode head) {
    ListNode p1 = head;
    ListNode p2 = head;
    while (p2 != null) {
      ListNode next = p2.next;
      if (next == null) {
        return p1;
      }
      p1 = p1.next;
      p2 = next.next;
    }
    return p1;
  }

  /**
   * @param head
   * @param left
   * @param right
   * @return Problem 92: Reverse Linked List II
   */
  public static ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(0, head);
    ListNode initialPrev = dummy;
    ListNode current = head;
    ListNode previous = null;
    for (int i = 0; i < left - 1; i++) {
      initialPrev = current;
      current = current.next;
    }
    for (int i = 0; i < right - left + 1; i++) {
      ListNode restNodes = current.next;
      ListNode temp = previous;
      previous = current;
      previous.next = temp;
      current = restNodes;
    }
    initialPrev.next.next = current;
    initialPrev.next = previous;
    return dummy.next;
  }

  /**
   * @param head
   * @return Problem:2807: Insert Greatest Common Divisors in LinkedList
   */
  public static ListNode insertGreatestCommonDivisors(ListNode head) {
    ListNode dummy = new ListNode(0,head);
    ListNode current = head;
    while (current.next != null) {
      ListNode gcd = new ListNode(gcdByEuclidsAlgorithm(current.val, current.next.val));
      System.out.println(gcd.val);
      gcd.next = current.next;
      current.next = gcd;
      current = current.next.next;
    }
    return dummy.next;
  }

  private static int gcdByEuclidsAlgorithm(int n1, int n2) {
    if (n2 == 0) {
      return n1;
    }
    return gcdByEuclidsAlgorithm(n2, n1 % n2);
  }
}

