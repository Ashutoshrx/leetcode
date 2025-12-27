package com.practice.leetcode.concepts.greedy;

import java.util.Arrays;

public class GreedyAlgoDemo {
  /**
   * @param g
   * @param s
   * @return Problem 455: Assign Cookies
   */
  public static int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0, j = 0, res = 0;
    while (i < g.length && j < s.length) {
      if (s[j] >= g[i]) {//this is sufficient to suffice the need of child
        res++;
        i++;
      }
      j++;
    }
    return res;
  }

  /**
   * @param bills
   * @return Problem: 860: Lemonade Change
   */
  public static boolean lemonadeChange(int[] bills) {
    int fiveCount = 0, tenCount = 0;
    for (int i : bills) {
      if (i == 5) {
        fiveCount++;
      } else if (i == 10) {
        tenCount++;
        if (fiveCount > 0) {
          fiveCount--;
        } else {
          return false;
        }
      } else {
        if (tenCount > 0 && fiveCount > 0) {
          tenCount--;
          fiveCount--;
        } else if (fiveCount >= 3) {
          fiveCount -= 2;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * @param apple
   * @param capacity
   * @return Problem: 3074 Apple Redistribution into Boxes
   */
  public static int minimumBoxes(int[] apple, int[] capacity) {
    int sum = Arrays.stream(apple).reduce(Integer::sum).getAsInt();
    Arrays.sort(capacity);
    int res = 0;
    int i = capacity.length - 1;
    while (i >= 0 && sum > 0) {
      sum -= capacity[i];
      capacity[i] = 0;
      res++;
      i--;
    }
    return res;
  }

  /**
   * @param happiness
   * @param k
   * @return Problem: 3075: Maximize happiness of selected children
   */
  public static long maximumHappinessSum(int[] happiness, int k) {
    Arrays.sort(happiness);
    int j = happiness.length - 1;
    int count = 0;
    long maxSum = 0, resultSum = 0;
    while (k > 0) {
      int currentSum = happiness[j] - count;
      resultSum += currentSum;
      count++;
      k--;
      j--;
      maxSum = Math.max(maxSum, resultSum);
    }
    return maxSum;
  }

  /**
   * @param nums
   * @return Problem: 55 Jump Game
   * @Resolution: Unsolved
   */
  public static boolean canJump(int[] nums) {//23114 //32104
    int i = 0;
    while (i + nums[i] >= nums.length - 1) {
      int previousStep = i;
      i += nums[i];
      if (previousStep == i) {
        return false;
      }
    }
    return true;
  }

}