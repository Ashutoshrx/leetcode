package com.practice.leetcode.concepts.design;

class SetNode {
  int key;
  int hashValue;
  SetNode next;

  public SetNode(int key, int hashValue, SetNode next) {
    this.key = key;
    this.hashValue = hashValue;
    this.next = next;
  }
}

public class MyHashSet {
  private static final int INITIAL_CAPACITY = 1000;
  SetNode[] hashTable;

  public MyHashSet() {
    hashTable = new SetNode[INITIAL_CAPACITY];
  }

  public void add(int key) {
    int hashValue = calculateHash(key);
    SetNode current = hashTable[hashValue];
    if (current == null) {
      hashTable[hashValue] = new SetNode(key, hashValue, null);
      return;
    }
    if (current.key == key) {
      System.out.println("Key exists: " + key);
      return;
    }
    while (current.next != null) {
      if (current.next.key == key) {
        return;
      }
      current = current.next;
    }
    current.next = new SetNode(key, hashValue, null);

  }

  public void remove(int key) {
    int hashValue = calculateHash(key);
    SetNode current = hashTable[hashValue];
    if (current == null) {
      return;
    }
    if (current.key == key) {
      hashTable[hashValue] = current.next;
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

  public boolean contains(int key) {
    int hashValue = calculateHash(key);
    SetNode current = hashTable[hashValue];
    if (current == null) {
      return false;
    }
    if (current.key == key) {
      return true;
    }
    while (current.next != null) {
      if (current.next.key == key) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  private int calculateHash(int key) {
    return key % INITIAL_CAPACITY;
  }
}