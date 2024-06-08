package com.practice.leetcode.solutions.linkedlist;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public void show() {
    System.out.print(val + ", ");
    while (next != null) {
      System.out.print(next.val + ", ");
      next = next.next;
    }
  }
}
