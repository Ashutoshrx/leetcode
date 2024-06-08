package com.practice.leetcode.solutions.queues;

public class Queue {
  int front = 0;
  int rear = 0;
  String[] queue = new String[5];

  public void insert(String data) {
    queue[rear] = data;
    rear++;
  }

  public boolean isEmpty() {
    return front == rear;
  }

  public void delete() {
    if (!isEmpty()) {
      queue[front] = null;
      front++;
    }
  }

  public void show() {
    for (int i = 0; i < rear; i++) {
      System.out.print(queue[front+i] + "," + "\n");
    }
  }

  public String peek() {
    return queue[front];
  }
}
