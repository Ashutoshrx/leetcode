package com.practice.leetcode.concepts;

import java.util.Arrays;

public class DynamicProgramming {
  public static int findFibonacci(int n, int[] qb) {
    //0,1,1,2,3,5,8,13,21,34,55
    if (n == 1 || n == 0) {
      return n;
    }
    if (qb[n] != 0) {
      return qb[n];
    }
    System.out.println("Hello:" + n);
    int i = findFibonacci(n - 1, qb) + findFibonacci(n - 2, qb);
    qb[n] = i;
    return i;
  }

  public static int climbStairs(int n) {
    return climbStairs(n, new int[n + 1]);
  }

  private static int climbStairs(int n, int[] qb) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }
    if (qb[n] != 0) {
      return qb[n];
    }
    System.out.println("Hello:" + n);
    int i1 = climbStairs(n - 1, qb);
    int i2 = climbStairs(n - 2, qb);
    int i = i1 + i2;
    qb[n] = i;
    return i;
  }

  public static int triFibonacci(int n) {
    return triFibN(n, new int[n + 1]);
  }

  private static int triFibN(int n, int[] x) {
    if (n == 1 || n == 0) {
      return n;
    }
    if (x[n] != 0) {
      return x[n];
    }
    var i = triFibN(n - 1, x) + triFibN(n - 2, x) + triFibN(n - 3, x);
    x[n] = i;
    return i;
  }

  /**
   *
   * @param coins
   * @param amount
   * @return Problem: 322: Coin Change
   */
  public static int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, -2);
    dp[0] = 0;
    int sol = coinChangeRec(coins, amount, dp);
    System.out.println(Arrays.toString(dp));
    return sol;
  }

  private static int coinChangeRec(int[] coins, int amount, int[] dp) {
    if (dp[amount] != -2) {
      System.out.println("Printed from existing data for value: " + amount + " which is : " + dp[amount]);
      return dp[amount];
    }
    int res = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (coin > amount) {
        continue;
      }
      int subProblem = coinChangeRec(coins, amount - coin, dp);
      if (subProblem != -1) {
        res = Math.min(subProblem + 1, res);
      }
    }
    dp[amount] = res != Integer.MAX_VALUE ? res : -1;
    return dp[amount];
  }
}
