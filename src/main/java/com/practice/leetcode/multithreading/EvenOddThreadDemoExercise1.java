package com.practice.leetcode.multithreading;

class SharedResource {
  private int number;

  public void printOdd() throws InterruptedException {
    synchronized (this) {
      while (number % 2 == 0) {
        wait();
      }
      System.out.println("Odd number: " + number);
      number++;
      notifyAll();
    }
  }

  public void printEven() throws InterruptedException {
    synchronized (this) {
      while (number % 2 != 0) {
        wait();
      }
      System.out.println("Even number: " + number);
      number++;
      notifyAll();
    }
  }
}

class EvenOddThreadDemoExercise1 {
  public static void main(String[] args) {

    SharedResource sharedResource = new SharedResource();
    Runnable runnable1 = () -> {
      for (int i = 0; i < 20; i++) {
        try {
          sharedResource.printEven();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }

    };
    Runnable runnable2 = () -> {
      for (int i = 0; i < 20; i++) {
        try {
          sharedResource.printOdd();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    };
    new Thread(runnable1).start();
    new Thread(runnable2).start();
  }
}
