package com.practice.leetcode.concepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HelloWorld {


  public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newFixedThreadPool(20);
    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      executorService.submit(() -> {
        int fact = fact(finalI);
        System.out.println(fact);
      });
    }
    executorService.shutdown();
    while (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
      System.out.println("waiting..");
    }
  }

  public static int fact(int x) {
    int result = 1;
    while (x > 0) {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      result *= x--;
    }
    return result;
  }
}



