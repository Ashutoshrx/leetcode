package com.practice.leetcode.solutions.linkedlist;

public class LinkedList {
  Node head;


  public void insert(String data) {
    Node newNode = new Node();
    newNode.setData(data);
    newNode.setNext(null);
    if (head == null) {
      head = newNode;
    } else {
      Node temp = head;
      while (temp.getNext() != null) {
        temp = temp.getNext();
      }
      temp.setNext(newNode);
    }

  }

  public void insertAtStart(String data) {
    Node newNode = new Node();
    newNode.setData(data);
    newNode.setNext(head);
    head = newNode;
  }

  public void insertAt(int index, String data) {
    Node newNode = new Node();
    newNode.setData(data);
    newNode.setNext(null);
    Node temp = head;
    int i = 0;
    while (i < index - 1) {
      temp = temp.getNext();
      i += 1;
    }
    newNode.setNext(temp.getNext());
    temp.setNext(newNode);
  }

  public void replaceAt(int index, String data) {
    Node newNode = new Node();
    newNode.setData(data);
    newNode.setNext(null);
    Node temp = head;
    int i = 0;
    while (i < index - 1) {
      temp = temp.getNext();
      i += 1;
    }
    newNode.setNext(temp.getNext().getNext());
    temp.setNext(newNode);
  }

  public void deleteAt(int index) {
    int i = 0;
    Node temp = head;
    while (i < index - 1) {
      temp = temp.getNext();
      i += 1;
    }
    temp.setNext(temp.getNext().getNext());
  }

  public void show() {
    while (head.getNext() != null) {
      System.out.println(head.getData());
      head = head.getNext();
    }
    System.out.println(head.getData());
  }
}

