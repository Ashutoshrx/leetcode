package com.practice.leetcode.solutions.multithreading;

import static com.practice.leetcode.solutions.multithreading.StringThread.a;
import static com.practice.leetcode.solutions.multithreading.StringThread.b;

class StringThread {
  public static StringBuilder a = new StringBuilder();
  public static StringBuffer b = new StringBuffer();


}

class Main {
  public static void main(String[] args) throws InterruptedException {

    Thread t1 = new Thread(() -> {
      for (int i = 0; i <= 5; i++) {
        synchronized (a) {
          a.append("1");
        }
        synchronized (b) {
          b.append("1");
        }
//        a.append("1");
//        System.out.println(a);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }, "First Thread");
    Thread t2 = new Thread(() -> {
      for (int i = 0; i <= 5; i++) {
        synchronized (a) {
          a.append("2");
        }
        synchronized (b) {
          b.append("2");
        }
//        System.out.println(a);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }, "Second Thread");

    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println("Builder:" + a);
    System.out.println("Buffer:" + b);


  }
}

