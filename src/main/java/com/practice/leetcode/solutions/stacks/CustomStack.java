package com.practice.leetcode.solutions.stacks;

import java.util.Arrays;

public class CustomStack {
  int[] stack;
  int top = 0;

  public CustomStack(int maxSize) {
    stack = new int[maxSize];
  }

  public void push(int x) {
    System.out.println(x + "is pushed");
    if (top < stack.length) {
      stack[top] = x;
      top++;
    }

  }

  public int pop() {
    if (top != 0) {
      System.out.println("to be popped: " + Arrays.toString(stack));
      int pop = stack[--top];
      stack[top] = 0;
      return pop;
    } else {
      return -1;
    }
  }

  public void increment(int k, int val) {
    int min = Math.min(k, top);
    for (int i = 0; i < min; i++) {
      stack[i] += val;
    }
  }

}