package com.practice.leetcode.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    int sol = coinChange(coins, amount, dp);
    System.out.println(Arrays.toString(dp));
    return sol;
  }

  private static int coinChange(int[] coins, int amount, int[] dp) {
    if (dp[amount] != -2) {
      return dp[amount];
    }
    int res = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (coin > amount) {
        continue;
      }
      int subProblem = coinChange(coins, amount - coin, dp);
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

  /**
   *
   * @param num
   */
  public static void printAllSubsequences(int[] num, int target) {
//    System.out.println(Arrays.toString(num));
    List<Integer> array = new ArrayList<>();
    int res = printAllSubsequences(num, 0, array, target, 0);
    System.out.println(res);
  }

  private static int printAllSubsequences(int[] nums, int currentIndex, List<Integer> array, int target, int sum) {
    if (currentIndex >= nums.length) {
      return 0;
    }
    array.add(nums[currentIndex]);
    int newSum = sum + nums[currentIndex];
    int count = 0;

    if (newSum == target) {
      System.out.println(array);
      count++;
    }
    // Extend the current contiguous subsequence
    count += printAllSubsequences(nums, currentIndex + 1, array, target, newSum);
    array.remove(array.size() - 1);
    // Start a fresh subsequence at the next index
    if (array.isEmpty()) {
      count += printAllSubsequences(nums, currentIndex + 1, new ArrayList<>(), target, 0);
    }
    return count;
  }

  /**
   *
   * @param nums
   * @return Problem: 198: House Robber
   */
  public static int rob(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    dp[0] = nums[0];
    int res = rob(nums, nums.length - 1, dp);
    System.out.println(Arrays.toString(dp));
    return res;
  }

  private static int rob(int[] nums, int currentIndex, int[] dp) {
    if (currentIndex < 0) {
      return 0;
    }
    if (dp[currentIndex] != -1) {
      return dp[currentIndex];
    }

    int pick = nums[currentIndex] + rob(nums, currentIndex - 2, dp);
    int notPick = rob(nums, currentIndex - 1, dp);
    int maxSum = Math.max(pick, notPick);
    return dp[currentIndex] = maxSum;
  }

  /**
   *
   * @param nums
   * @return Frog Jump-Source: https://www.youtube.com/watch?v=EgG3jsGoPvQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=4
   * This approach is memoization- top-down approach
   */
  public static int jump(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    int res = jump(nums, nums.length - 1, dp);
    System.out.println(Arrays.toString(dp));
    return res;
  }

  private static int jump(int[] nums, int currentIndex, int[] dp) {
    if (currentIndex == 0) {
      return 0;
    }
    if (dp[currentIndex] != -1) {
      System.out.println("taking from index: " + currentIndex);
      return dp[currentIndex];
    }
    int left = jump(nums, currentIndex - 1, dp) + Math.abs(nums[currentIndex] - nums[currentIndex - 1]);
    int right = Integer.MAX_VALUE;
//    System.out.println(currentIndex);
    if (currentIndex > 1) {
      right = jump(nums, currentIndex - 2, dp) + Math.abs(nums[currentIndex] - nums[currentIndex - 2]);
    }
    return dp[currentIndex] = Math.min(left, right);
  }

  /**
   *
   * @param nums
   * @return the above example is solved by top-down approach which we call it as tabularization
   */
  public static int jump2(int[] nums) {
//    int[] dp = new int[nums.length];
//    Arrays.fill(dp, -1);
//    dp[0] = 0;
    int prev = 0, prev2 = 0;
    int firstStep, secondStep = Integer.MAX_VALUE;
    for (int i = 1; i < nums.length; i++) {
      firstStep = prev + Math.abs(nums[i] - nums[i - 1]);
      if (i > 1) {
        secondStep = prev2 + Math.abs(nums[i] - nums[i - 2]);
      }
      prev2 = prev;
      prev = Math.min(firstStep, secondStep);
    }
//    System.out.println(Arrays.toString(dp));
    return prev;
  }

  /**
   *
   * @param nums
   * @param target
   * @return Problem: 2770: Maximum number of jumps to reach the last index
   */
  public static int maximumJumps(int[] nums, int target) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    int res = maximumJumps(nums, n - 1, dp, target);
    System.out.println(Arrays.toString(dp));
    return res;
  }

  private static int maximumJumps(int[] nums, int currentIndex, int[] dp, int target) {
    if (currentIndex == 0) {
      return 0;
    }
    int jumps = Integer.MIN_VALUE;
    for (int i = 0; i < currentIndex; i++) {
      if (Math.abs(nums[i] - nums[currentIndex]) <= target) {
        int prev = maximumJumps(nums, i, dp, target);
        jumps = Math.max(jumps, prev + 1);
      }
    }
    if (jumps != Integer.MIN_VALUE) {
      dp[currentIndex] = jumps;
    }
    return dp[currentIndex] = jumps;
  }

  /**
   *
   * @param nums
   * @param target
   * @return Problem: 2770: Maximum number of jumps to reach the last index
   */
  public static int maximumJumpsApproach2(int[] nums, int target) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] != -1 && Math.abs(nums[j] - nums[i]) <= target) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    System.out.println(Arrays.toString(dp));
    return dp[n - 1];
  }

  /**
   *
   * @param n
   * @param costs
   * @return 3693. Climbing Stairs II
   */
  public static int climbStairs1(int n, int[] costs) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    int res = climbStairs1(n, costs, dp);
    System.out.println(Arrays.toString(dp));
    return res;
  }

  private static int climbStairs1(int currentIndex, int[] costs, int[] dp) {
    if (currentIndex <= 0) {
      return dp[0];
    }
    if (dp[currentIndex] != -1) {
      return dp[currentIndex];
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= 3; i++) {
      int newIndex = currentIndex - i;
      if (newIndex >= 0) {
        int current = climbStairs1(newIndex, costs, dp);
        int cost = (currentIndex - newIndex) * (currentIndex - newIndex);
        System.out.println("Cost: " + cost);
        min = Math.min(min, current + costs[currentIndex - 1] + cost);
      }
    }
    return dp[currentIndex] = min;
  }
}