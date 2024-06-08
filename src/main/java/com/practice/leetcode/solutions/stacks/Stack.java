package com.practice.leetcode.solutions.stacks;

public class Stack {
  int top = 0;
  String[] stack = new String[5];

  public boolean isEmpty() {
    return top == 0;
  }

  public void push(String data) {
    stack[top] = data;
    top++;
  }

  public void pop() {
    if (!isEmpty()) {
      stack[top] = null;
      top--;
    }
  }

  public void show() {
    for (int i = 0; i < top; i++) {
      System.out.print(stack[i] + ",");
    }
  }

  public int size() {
    return top;
  }
}
