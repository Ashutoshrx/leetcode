package com.practice.leetcode.solutions.multithreading;

class ExtendThread {
  public static void main(String... args) throws Exception {
    Thread t1 = new Thread(() -> {
      try {
        for (int i = 0; i < 10; i++) {
          System.out.println("T1:" + i);
          Thread.sleep(500);
        }
      } catch (Exception e) {
        System.out.println("Child Thread interrupted");
      }
      System.out.println("Exiting child t1");
    }, "Thread-1");
    Thread t2 = new Thread(() -> {
      try {
        for (int i = 0; i < 10; i++) {
          System.out.println("T2:" + i);
          Thread.sleep(500);
        }
      } catch (Exception e) {
        System.out.println("Child Thread interrupted");
      }
      System.out.println("Exiting child t2");
    }, "Thread-2");
    t1.setPriority(Thread.MIN_PRIORITY);
    t2.setPriority(Thread.MAX_PRIORITY);
    t1.start();
    t2.start();

    t1.join();
    t2.join();
    System.out.println("Main Thread ended");
  }
}

//class Q {
//  int num;
//  boolean isAssigned = false;
//
//  public synchronized void put(int n) {   ////PUT METHOD
//    while (isAssigned) {
//      try {
//        wait();
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
//    }
//    System.out.println("PUT: " + n);
//    this.num = n;
//    this.isAssigned = true;
//    notify();
//  }
//
//  public synchronized void get() {     /////GET METHOD
//    while (!isAssigned) {
//      try {
//        wait();
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
//    }
//    System.out.println("GET: " + num);
//    this.isAssigned = false;
//    notify();
//  }
//
//
//}
//
//class Producer implements Runnable {
//  Q q;
//
//  public Producer(Q q) {
//    this.q = q;
//    Thread t = new Thread(this, "Producer");
//    t.start();
//  }
//
//  @Override
//  public void run() {
//    int i = 0;
//    while (true) {
//      q.put(i++);
//      try {
//        Thread.sleep(1000);
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
//    }
//  }
//}
//
//class Consumer implements Runnable {
//  Q q;
//
//  public Consumer(Q q) {
//    this.q = q;
//    Thread t = new Thread(this, "Consumer");
//    t.start();
//  }
//
//  @Override
//  public void run() {
//    while (true) {
//      q.get();
//      try {
//        Thread.sleep(1000);
//      } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//      }
//    }
//  }
//}
//https://www.youtube.com/watch?v=A1tnVMpWHh8&list=PLsyeobzWxl7rmuFYRpkqLanwoG4pQQ7oW&index=9
class Q {
  int data;

  public void put(int n) {
    System.out.println("PUT:" + n);
    this.data = n;
  }

  public void get() {
    System.out.println("GET:" + data);
  }
}

class Consumer implements Runnable {
  Q q;

  public Consumer(Q q) {
    this.q = q;
    run();
  }

  @Override
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

class Producer implements Runnable {
  Q q;

  public Producer(Q q) {
    this.q = q;
    run();
  }

  @Override
  public void run() {
    int i = 0;
    while (true) {
      q.put(i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

class Counter {
  public static void main(String[] args) {
    Q q = new Q();
    new Consumer(q);
    new Producer(q);
  }
}



