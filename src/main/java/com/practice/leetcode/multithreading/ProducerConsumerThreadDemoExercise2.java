package com.practice.leetcode.multithreading;

class Queue {
  private int num;
  private boolean isSet = false;

  public void put(int input) throws InterruptedException {
    synchronized (this) {
      while (isSet) {
        wait();
      }
      this.num = input;
      System.out.println("PUT: " + num);
      isSet = true;
      notifyAll();
    }
  }

  public void get() throws InterruptedException {
    synchronized (this) {
      while (!isSet) {
        wait();
      }
      System.out.println("GET: " + num);
      isSet = false;
      notifyAll();
    }
  }
}

class ProducerConsumerThreadDemoExercise2 {
  public static void main(String[] args) {
    Queue q = new Queue();

    Runnable producer = () -> {
      for (int i = 0; i < 100; i++) {
        try {
          q.put(i);
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    };
    Runnable consumer = () -> {
      for (int i = 0; i < 100; i++) {
        try {
          q.get();
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    };
    new Thread(producer).start();
    new Thread(consumer).start();


  }
}
