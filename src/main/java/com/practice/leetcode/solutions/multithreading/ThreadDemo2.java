package com.practice.leetcode.solutions.multithreading;

public class ThreadDemo2 {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("Hello");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });
    Thread t2 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("Hi");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });

    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println("Everything ended");
  }

}
