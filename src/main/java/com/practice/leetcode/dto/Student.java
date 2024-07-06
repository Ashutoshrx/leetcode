package com.practice.leetcode.dto;

import com.practice.leetcode.solutions.linkedlist.ListNode;

public class Student implements Cloneable {
  public String firstName;
  public String lastName;
  public ListNode node;

  public Student(String firstName, String lastName, ListNode node) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.node = node;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
