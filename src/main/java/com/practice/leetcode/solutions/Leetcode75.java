package com.practice.leetcode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode75 {
  public static void main(String[] args) {
//    String s = mergeAlternately("abc", "pqr");
//    String s = mergeAlternately("ab", "pqrs");
//    int s = removeDuplicates(new int[]{1, 1, 2});
//    int s = removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
//    moveZeroes(new int[]{0, 1, 0, 3, 12});
//    int s = pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
//    var s = findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
    var s = longestPalindromeSubstring("cbbd");
//    var s = longestPalindromeSubstring("babad");
    System.out.println(s);

  }

  public static String mergeAlternately(String word1, String word2) {
    StringBuilder res = new StringBuilder();
    int left = 0, right = 0;
    while (left < word1.length() && right < word2.length()) {
      res.append(word1.charAt(left));
      left++;
      res.append(word2.charAt(right));
      right++;
    }
    while (left < word1.length()) {
      res.append(word1.charAt(left));
      left++;
    }
    while (right < word2.length()) {
      res.append(word2.charAt(right));
      right++;
    }
    return res.toString();
  }

  public static int removeDuplicates(int[] nums) {
    int newIndex = 1;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] < nums[i + 1]) {
        nums[i] = nums[i + 1];
        newIndex++;
      }
    }
    return newIndex;
  }

  public static void moveZeroes(int[] nums) {
    int left = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[left];
        nums[left] = nums[i];
        nums[i] = temp;
        left++;
      }
    }
    System.out.println(Arrays.toString(nums));
  }

  public static int pivotIndex(int[] nums) {
    int sum = Arrays.stream(nums).reduce(0, Integer::sum);
    int currentSum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum -= nums[i];
      if (sum == currentSum) {
        return i;
      }
      currentSum += nums[i];
    }
    return -1;
  }

  /**
   * @param nums
   * @param k
   * @return Problem:643: Maximum Average Subarray 1
   */
  public static double findMaxAverage(int[] nums, int k) {
    int i = 0;
    int sum = 0;
    int length = nums.length;
    for (; i < k; i++) {
      sum += nums[i];
    }
    double avg = (double) sum / k;
    for (; i < length; i++) {
      sum += nums[i];
      sum -= nums[i - k];
      double currentAvg = (double) sum / k;
      avg = Math.max(currentAvg, avg);
    }
    return avg;
  }

  public static int longestPalindrome(String s) {
    int res = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
      if (map.get(s.charAt(i)) % 2 == 0) {
        res += 2;
      }
    }
    return map.values().stream().anyMatch(x -> x % 2 != 0) ? res + 1 : res;
  }

  public static String longestPalindromeSubstring(String s) {
    String res = "";
    int maxLen = 0;
    for (int i = 0; i < s.length(); i++) {
      int left = i, right = i;
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        if (right - left + 1 > maxLen) {
          res = s.substring(left, right + 1);
          maxLen = right - left + 1;
        }
        left--;
        right++;
      }
      left = i;
      right = i + 1;
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        if (right - left + 1 > maxLen) {
          res = s.substring(left, right + 1);
          maxLen = right - left + 1;
        }
        left--;
        right++;
      }
    }
    return res;
  }
}

