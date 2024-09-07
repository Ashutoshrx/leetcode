package com.practice.leetcode.patterns;

public class Pattern {
//  https://www.geeksforgeeks.org/java-pattern-programs/


  public static void printNumberTriangular(int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

}
