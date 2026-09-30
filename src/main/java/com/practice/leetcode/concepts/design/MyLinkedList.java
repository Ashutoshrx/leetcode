package com.practice.leetcode.concepts.design;

class LinkedNode {
  int value;
  LinkedNode next;

  public LinkedNode(int value, LinkedNode next) {
    this.value = value;
    this.next = next;
  }
}

public class MyLinkedList {
  LinkedNode node;

  public MyLinkedList() {
    node = null;
  }

  public int get(int index) {
    int count = 0;
    LinkedNode temp = node;
    while (count < index && temp != null) {
      count++;
      temp = temp.next;
    }
    return temp == null ?
            -1 :
            temp.value;
  }

  public void addAtHead(int val) {
    LinkedNode nextNode = node;
    node = new LinkedNode(val, nextNode);
  }

  public void addAtTail(int val) {
    if (node == null) {
      node = new LinkedNode(val, null);
      return;
    }
    LinkedNode temp = node;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = new LinkedNode(val, null);
  }

  public void addAtIndex(int index, int val) {
    if (index == 0) {
      addAtHead(val);
      return;
    }
    LinkedNode temp = node;
    int count = 0;
    while (count < index - 1 && temp != null) {
      temp = temp.next;
      count++;
    }
    if (temp == null) {
      return;
    }
    if (temp.next == null) {
      addAtTail(val);
      return;
    }
    LinkedNode nextNode = temp.next;
    temp.next = new LinkedNode(val, nextNode);

  }

  public void deleteAtIndex(int index) {
    if (index == 0) {
      node = node.next;
      return;
    }
    LinkedNode temp = node;
    int count = 0;
    while (count < index - 1 && temp != null) {
      temp = temp.next;
      count++;
    }
    if (temp == null) {
      return;
    }
    if (temp.next != null) {
      temp.next = temp.next.next;
    }
  }
}
