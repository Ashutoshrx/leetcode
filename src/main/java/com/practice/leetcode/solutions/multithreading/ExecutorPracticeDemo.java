package com.practice.leetcode.solutions.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorPracticeDemo {
  public static void main(String[] args) {
//    Thread[] threads = new Thread[3];
    long startTime = System.currentTimeMillis();
    ExecutorService executor = Executors.newFixedThreadPool(3);
    for (int i = 1; i <= 10; i++) {
      int temp = i;
      executor.submit(() -> {
        int factorial = factorial(temp);
        System.out.println("Factorial is " + temp + ":" + factorial);
      });
      /*threads[i - 1] = new Thread(() -> {
        int factorial = factorial(temp);
        System.out.println(temp + ":" + factorial);
      });
      threads[i - 1].start();*/
    }
    executor.shutdown();
    System.out.println("Total Time: " + (System.currentTimeMillis() - startTime));
  }

  public static int factorial(int n) {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    int res = 1;
    for (int i = n; i > 0; i--) {
      res *= i;
    }
    return res;
  }
}
