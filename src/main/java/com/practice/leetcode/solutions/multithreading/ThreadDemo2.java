package com.practice.leetcode.solutions.multithreading;

class ThreadDemo2 {
  public static void main(String[] args) throws InterruptedException {
    Pen pen = new Pen();
    Paper paper = new Paper();
    PenAndPaper penAndPaper = new PenAndPaper();
    Thread person3 = new Thread(penAndPaper::write, "Person-3");
    Thread person4 = new Thread(penAndPaper::write, "Person-4");
    Thread person5 = new Thread(penAndPaper::write, "Person-5");
    person3.start();
    person4.start();
    person5.start();
    /*Thread person1 = new Thread(() -> {
      System.out.println("Person-1 started writing using pen");
      pen.writeOn(paper);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, "Person-1");
    Thread person2 = new Thread(() -> {
      System.out.println("Person-2 started writing using paper");
      paper.writeWith(pen);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, "Person-2");
    person1.start();
    person2.start();*/
  }
}

class Pen {

  public synchronized void writeOn(Paper paper) {
    System.out.println("Starting writing on paper using: " + Thread.currentThread().getName());
    paper.writeWith(this);
  }
}

class Paper {

  public synchronized void writeWith(Pen pen) {
    System.out.println("Started writing using pen using: " + Thread.currentThread().getName());
    pen.writeOn(this);
  }
}

class PenAndPaper {
  private final Object pen = new Object();
  private final Object paper = new Object();

  public void write() {
    synchronized (pen) {
      System.out.println(Thread.currentThread().getName() + " locked Pen");
      try {
        Thread.sleep(100);
      } catch (InterruptedException ignored) {
      }
      synchronized (paper) {
      System.out.println(Thread.currentThread().getName() + " locked Paper and is writing...");
      }
    }
  }
}
