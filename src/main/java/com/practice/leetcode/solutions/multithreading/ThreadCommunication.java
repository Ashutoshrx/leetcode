package com.practice.leetcode.solutions.multithreading;

class Printer {
  int data;
  boolean isAssigned = false;

  synchronized void put(int n) {
    while (isAssigned) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    System.out.println("PUT: " + n);
    this.data = n;
    isAssigned = true;
    notify();
  }

  synchronized void get() {
    while (!isAssigned) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    System.out.println("GET: " + this.data);
    isAssigned = false;
    notify();
  }
}

class Producer1 implements Runnable {
  Printer printer;

  public Producer1(Printer printer) {
    this.printer = printer;
    Thread t = new Thread(this, "Producer");
    t.start();
  }

  @Override
  public void run() {
    int i = 1;
    while (true) {
      printer.put(i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      i += 2;
    }
  }
}

class Consumer1 implements Runnable {
  Printer printer;

  public Consumer1(Printer printer) {
    this.printer = printer;
    Thread t = new Thread(this, "Consumer");
    t.start();
  }

  @Override
  public void run() {
    while (true) {
      printer.get();
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

public class ThreadCommunication {
  public static void main(String[] args) {
    Printer printer = new Printer();
    new Producer1(printer);
    new Consumer1(printer);
  }
}
