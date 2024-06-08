package com.practice.leetcode.solutions.exceptions;

public class MyException extends Throwable {
  private int detail;

  MyException(int a) {
    detail = a;
  }

  public String toString() {
    return "MyException [" + detail + "]";
  }
}

class ExceptionDemo {
  static void compute(int a) throws MyException {
    System.out.println("Called compute method");
    if (a > 5) {
      throw new MyException(a);
    }
  }

  public static void main(String[] args) {
    try {
      compute(7);
    } catch (MyException e) {
      System.out.println(e);
    }
  }
}
