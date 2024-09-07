package com.practice.leetcode.solutions.multithreading;

class ExtendThread {
  public static void main(String... args) throws Exception {
    Q q = new Q();
    new Producer(q);
    new Consumer(q);
  }
}

class Q {
  int num;
  boolean isAssigned = false;

  public synchronized void put(int i) {
    while (isAssigned) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    this.num = i;
    System.out.println("PUT:" + num);
    this.isAssigned = true;
    notify();
  }

  public synchronized void get() {
    while (!isAssigned) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    System.out.println("GET:" + num);
    this.isAssigned = false;
    notify();
  }
}

class Producer implements Runnable {
  Q q;
  int i = 0;

  public Producer(Q q) {
    Thread t1 = new Thread(this);
    t1.start();
    this.q = q;
  }

  public void run() {
    while (true) {
      q.put(i++);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

class Consumer implements Runnable {
  Q q;

  public Consumer(Q q) {
    Thread t1 = new Thread(this);
    t1.start();
    this.q = q;
  }

  public void run() {
    while (true) {
      q.get();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}






