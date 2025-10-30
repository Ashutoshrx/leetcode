package com.practice.leetcode;

class Singleton {
  private static Singleton INSTANCE;
  private final String value;

  private Singleton(String value) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    this.value = value;
  }

  private static Singleton getInstance(String value) {
    if (INSTANCE == null) {
      System.out.println("started creating new instance for: " + value);
      synchronized (Singleton.class) {
        if (INSTANCE == null) {
          System.out.println("started creating inside double lock: " + value);
          INSTANCE = new Singleton(value);
        }
      }
    }
    return INSTANCE;
  }

  public static void main(String[] args) throws InterruptedException {
    //Single Thread - Singleton
//    System.out.println("Single Thread - Singleton starts here");
/*
    Singleton firstInstance = Singleton.getInstance("ASHUTOSH");
    Singleton secondInstance = Singleton.getInstance("SATAPATHY");

    System.out.println(firstInstance.value);
    System.out.println(secondInstance.value);
*/
//    System.out.println("Single Thread - Singleton ends here");
    System.out.println("Multi Thread - Singleton starts here");

    Thread firstInstanceThread = new Thread(() -> {
      Singleton singleton = Singleton.getInstance("ASHUTOSH");
      System.out.println(singleton.value);
    });

    Thread secondInstanceThread = new Thread(() -> {
      Singleton singleton = Singleton.getInstance("SATAPATHY");
      System.out.println(singleton.value);
    });
    firstInstanceThread.start();
    secondInstanceThread.start();
    firstInstanceThread.join();
    secondInstanceThread.join();
    System.out.println("Multi Thread - Singleton ends here");
    //Single Thread - Singleton ends here
  }
}
