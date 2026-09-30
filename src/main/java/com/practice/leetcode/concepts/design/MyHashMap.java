package com.practice.leetcode.concepts.design;


class Node {
  int key;
  int value;
  Node next;

  public Node(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

public class MyHashMap {

  public static final int INITIAL_CAPACITY = 1000;
  Node[] hashTable;


  public MyHashMap() {
    hashTable = new Node[INITIAL_CAPACITY];
  }

  public void put(int key, int value) {
    int hash = getHash(key);
    Node current = hashTable[hash];
    if (current == null) {
      hashTable[hash] = new Node(key, value);
    } else {
      while (current != null) {
        if (current.key == key) {
          current.value = value;
          break;
        } else if (current.next == null) {
          current.next = new Node(key, value);
          break;
        }
        current = current.next;
      }
    }
  }

  public int get(int key) {
    int hash = getHash(key);
    Node current = hashTable[hash];
    if (current == null) {
      System.out.println("No Data found for key: " + key);
      return -1;
    } else {
      while (current != null) {
        if (current.key == key) {
          return current.value;
        }
        current = current.next;
      }
    }
    return -1;
  }

  private int getHash(int key) {
    return key % 1000;
  }

  public void remove(int key) {
    int hash = getHash(key);
    Node current = hashTable[hash];
    if (current == null) {
      System.out.println("No Data found for key: " + key);
      return;
    }
    if (current.key == key) {
      hashTable[hash] = current.next;
      return;
    }
    while (current.next != null) {
      if (current.next.key == key) {
        current.next = current.next.next;
        return;
      }
      current = current.next;
    }
  }
}
