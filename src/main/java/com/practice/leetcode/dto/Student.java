package com.practice.leetcode.dto;

import com.practice.leetcode.solutions.linkedlist.ListNode;

public class Student implements Cloneable {
  public String firstName;
  public String lastName;
  public ListNode node;

  public Student(Student that) {
    this(that.getFirstName(), that.getLastName());
  }


  public Student(String firstName, String lastName, ListNode node) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.node = node;
  }

  public Student(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public ListNode getNode() {
    return node;
  }

  public void setNode(ListNode node) {
    this.node = node;
  }

  @Override
  public String toString() {
    return "Student{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", node=" + node +
            '}';
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
