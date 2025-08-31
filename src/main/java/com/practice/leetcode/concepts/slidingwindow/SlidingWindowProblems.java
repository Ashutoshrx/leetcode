package com.practice.leetcode.concepts.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SlidingWindowProblems {
  public static int lengthOfLongestSubstring(String s) {
    System.out.println(s);
    int left = 0;
    int right = 0;
    int res = 0;
    Set<Character> chars = new HashSet<>();
    for (; right < s.length(); right++) {
      while (chars.contains(s.charAt(right))) {
        chars.remove(s.charAt(left));
        left++;
      }
      chars.add(s.charAt(right));
      res = Math.max(res, right - left + 1);
      System.out.println(chars);
    }
    return res;
  }

  public static int removeDuplicates(int[] nums) {
    int i = 0, j = 1;
    while (j < nums.length) {
      if (nums[i] == nums[j]) {
        j++;
      } else {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

  /**
   * @param nums
   * @param k
   * @return
   * @Problem: 219: Contains Duplicates 2
   */
  public static boolean containsNearbyDuplicateNeetCode(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int left = 0; left < nums.length; left++) {
      if (map.get(nums[left]) != null && Math.abs(map.get(nums[left]) - left) <= k) {
        return true;
      } else {
        map.put(nums[left], left);
      }
    }
    return false;
  }

  /**
   * @param nums
   * @Problem 283: Move Zeroes
   * @Input [0, 1, 0, 3, 12]
   */
  public static int[] moveZeroes(int[] nums) {
    int left = 0, right = 0;
    while (right < nums.length) {
      if (nums[right] == 0) {
        right++;
      } else {
        nums[left] ^= nums[right];
        nums[right] ^= nums[left];
        nums[left] ^= nums[right];
        left++;
      }
    }
    return nums;
  }

  /**
   * @param chars
   * @return Problem: 443: String Compression
   */
  public static int compress(char[] chars) {
    System.out.println(chars);
    int res = 0;
    int left = 0, right = 0;
    for (; right < chars.length; right++) {
      if (chars[right] != chars[left]) {
        if (right - left + 1 > 1) {
          char i = Character.forDigit(right - left, 10);
          chars[left + 1] = i;
          res += 2;
          System.out.println(chars);
        } else {
          System.out.println(chars);
        }
        left = right + 1;
      }
    }
    if (left + 1 != right) {
      while ((right - left) / 10 != 0) {
        char div = Character.forDigit((right - left) / 10, 10);
        chars[left + 1] = div;
        char rem = Character.forDigit((right - left) % 10, 10);
        chars[left + 2] = rem;
      }
      char i = Character.forDigit(right - left, 10);
      res += 2;
      chars[left + 1] = i;
    } else {
      res++;
    }
    System.out.println(chars);
    return res;
  }

  /**
   * @param s
   * @return Problem: 5: Longest Palindromic Substring
   */
  public static String longestPalindrome(String s) {
    String res = "";
    int maxLength = 0;
    for (int i = 0; i < s.length(); i++) {
      int left = i, right = i;
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        if (right - left + 1 > maxLength) {
          maxLength = right - left + 1;
          res = s.substring(left, right + 1);
        }
        left--;
        right++;
      }
      left = i;
      right = i + 1;
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        if (right - left + 1 > maxLength) {
          maxLength = right - left + 1;
          res = s.substring(left, right + 1);
        }
        left--;
        right++;
      }
    }
    return res;
  }


}
