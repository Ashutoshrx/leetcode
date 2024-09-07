package com.practice.leetcode.solutions.linkedlist;

public class LinkedList {
  Node head;
  int size;


  public void insert(String data) {
    Node newNode = new Node();
    newNode.data = data;
    if (head == null) {
      head = newNode;
    } else {
      Node temp = head;
      while (temp.next != null) {
        size += 1;
        temp = temp.next;
      }
      temp.next = newNode;
    }
  }

  public void insertAtStart(String data) {
    Node newNode = new Node();
    newNode.data = data;
    newNode.next = head;
    head = newNode;
  }

  public void insertAt(int index, String data) {
    Node newNode = new Node();
    newNode.data = data;
    Node curr = head;
    for (int i = 0; i < index; i++) {
      curr = curr.next;
    }
    newNode.next = curr.next;
    curr.next = newNode;
  }

  public void replaceAt(int index, String data) {
    this.show();
    Node newNode = new Node();
    newNode.data = data;
    System.out.println("\nReplace at:" + index);
    Node curr = head;
    Node n1;
    for (int i = 0; i < index - 1; i++) {
      curr = curr.next;
    }
    n1 = curr.next;
    newNode.next = n1.next;
    curr.next = newNode;
  }

  public void deleteAt(int index) {
    this.show();
    System.out.println("\nDelete the above list at index: " + index);
    if (index == 0) {
      head = head.next;
    } else {
      Node curr = head;
      Node n1;
      for (int i = 0; i < index - 1; i++) {
        curr = curr.next;
      }
      n1 = curr.next;
      curr.next = n1.next;
    }
  }

  public void show() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + ", ");
      temp = temp.next;
    }
  }
}

