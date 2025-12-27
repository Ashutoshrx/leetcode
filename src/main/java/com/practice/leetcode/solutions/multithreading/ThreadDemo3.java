package com.practice.leetcode.solutions.multithreading;

class ThreadDemo3 {
  public static void main(String[] args) {
    Pen2 pen = new Pen2();
    Paper2 paper = new Paper2();
    Thread t1 = new Thread(() -> pen.writeWithPaper(paper), "Thread-1");
    Thread t2 = new Thread(() -> {
//      synchronized (pen) {
        paper.writeWithPaper(pen);
//      }
    }, "Thread-2");
    t1.start();
    t2.start();
  }


}

class Pen2 {
  public synchronized void writeWithPaper(Paper2 paper) {
    System.out.println("Starting to write and waiting for paper:" + Thread.currentThread().getName());
    paper.startWriting();
  }

  public synchronized void startWriting() {
    System.out.println("Starting to write using Pen: " + Thread.currentThread().getName());
  }

}

class Paper2 {
  public synchronized void writeWithPaper(Pen2 pen) {
    System.out.println("Starting to write and waiting for pen:" + Thread.currentThread().getName());
    pen.startWriting();
  }

  public synchronized void startWriting() {
    System.out.println("Starting to write using Paper: " + Thread.currentThread().getName());
  }
}

