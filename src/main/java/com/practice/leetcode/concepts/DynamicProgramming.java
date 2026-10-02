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

  /**
   *
   * @param current
   * @param correct
   * @return Problem: 2224: Minimum number of operations to convert time
   */
  public static int convertTime(String current, String correct) {
    int[] splitCurrent = Arrays.stream(current.split(":")).mapToInt(Integer::parseInt).toArray();
    int[] splitCorrect = Arrays.stream(correct.split(":")).mapToInt(Integer::parseInt).toArray();
    int timeDifference = ((splitCorrect[0] * 60) + splitCorrect[1]) - ((splitCurrent[0] * 60) + splitCurrent[1]);
    System.out.println("total time diff: " + timeDifference);
    int[] minutes = new int[]{1, 5, 15, 60};
    int[] dp = new int[timeDifference + 1];
    Arrays.fill(dp, -2);
    dp[0] = 0;
    int sol = convertTime(minutes, timeDifference, dp);
    System.out.println(Arrays.toString(dp));
    return sol;
  }

  private static int convertTime(int[] minutes, int time, int[] dp) {
    if (time < 0) {
      return -1;
    }
    if (dp[time] != -2) {
      return dp[time];
    }
    int res = Integer.MAX_VALUE;
    for (int minute : minutes) {
      if (time - minute < 0) {
        continue;
      }
      int operationCount = convertTime(minutes, time - minute, dp);
      if (operationCount != -1) {
        res = Math.min(operationCount + 1, res);
      }
    }
    dp[time] = res != Integer.MAX_VALUE ? res : -1;
    return dp[time];
  }

  /**
   *
   * @param cost
   * @return Problem: 746: Min Cost Climbing Stairs
   */
  public static int minCostClimbingStairs(int[] cost) {
    int length = cost.length;
    int[] dp = new int[length + 1];
    Arrays.fill(dp, -1);
    int sol = minCostClimbingStairs(cost, dp, length);
    System.out.println(Arrays.toString(dp));
    return sol;
  }

  private static int minCostClimbingStairs(int[] cost, int[] dp, int currentIndex) {
    if (currentIndex <= 1) {
      return 0;
    }
    if (dp[currentIndex] != -1) {
      return dp[currentIndex];
    }
    int l1 = minCostClimbingStairs(cost, dp, currentIndex - 1) + cost[currentIndex - 1];
    int l2 = minCostClimbingStairs(cost, dp, currentIndex - 2) + cost[currentIndex - 2];
    int res = Math.min(l1, l2);
    dp[currentIndex] = res;
    return dp[currentIndex];
  }


}
