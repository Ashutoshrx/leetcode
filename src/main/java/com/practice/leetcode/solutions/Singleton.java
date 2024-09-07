package com.practice.leetcode.solutions;

public class Singleton {
  private static Singleton obj;

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (obj == null) {
      synchronized (Singleton.class){
        if(obj==null){
          obj= new Singleton();
        }
      }
      obj = new Singleton();
      return obj;
    } else {
      return obj;
    }
  }
}

class Main {
  public static void main(String[] args) {
    Singleton singleton1 = Singleton.getInstance();
    Singleton singleton = Singleton.getInstance();
    System.out.println(singleton1.equals(singleton));
//    System.out.println(singleton);
  }
}
