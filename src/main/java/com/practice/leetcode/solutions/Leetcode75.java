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

  /**
   * @param str1
   * @param str2
   * @return Problem 1071: Greatest Common Divisor of Strings
   * @resolution Unresolved
   */
  public static String gcdOfStrings(String str1, String str2) {
    String res = "";
    int length1 = str1.length();
    int length2 = str2.length();
    if (length2 > length1) {
      for (int i = 0; i < length1; i++) {
        String prefix = str1.substring(0, i + 1);
        if (str1.contains(prefix) && str2.contains(prefix) && prefix.length() > res.length()) {
          res = prefix;
        }
      }
    } else {
      for (int i = 0; i < length2; i++) {
        String prefix = str2.substring(0, i + 1);
        if (str1.contains(prefix) && str2.contains(prefix) && prefix.length() > res.length()) {
          res = prefix;
        }
      }
    }
    return res;
  }

  /**
   * @param nums
   * @Problem: 283: Move zeroes
   */
  public static void moveZeroes1(int[] nums) {
    int l = 0, r = 0;
    while (r < nums.length) {
      if (nums[r] != 0) {
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
        l++;
      }
      r++;
    }
    System.out.println(Arrays.toString(nums));
  }

  /**
   * @param s
   * @param t
   * @return Problem: 392: Is Subsequence
   */
  public static boolean isSubsequence(String s, String t) {
    if (!s.isEmpty()) {
      int l1 = 0, l2 = 0;
      while (l2 < t.length()) {
        if (s.charAt(l1) == t.charAt(l2)) {
          System.out.println("Fount match of: " + s.charAt(l1));
          l1++;
        }
        l2++;
      }
      return l1 == s.length();
    }
    return false;
  }

  /**
   * @param nums
   * @return Problem: 238: Product of Array except self
   */
  public static int[] productExceptSelf(int[] nums) {
    int[] prefix = new int[nums.length];
    int[] postfix = new int[nums.length];
    int[] res = new int[nums.length];
    int currentProduct = 1;
    for (int i = 0; i < nums.length; i++) {
      currentProduct *= nums[i];
      prefix[i] = currentProduct;
    }
    System.out.println(Arrays.toString(prefix));
    currentProduct = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      currentProduct *= nums[i];
      postfix[i] = currentProduct;
    }
    System.out.println(Arrays.toString(postfix));
    res[0] = postfix[1];
    res[nums.length - 1] = prefix[nums.length - 2];
    for (int i = 1; i < nums.length - 1; i++) {
      res[i] = prefix[i - 1] * postfix[i + 1];
    }
    return res;
  }

  /**
   * @param height
   * @return Problem:11 Container with most water
   */
  public static int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int maxArea = 0;
    while (left < right) {
      int length = Math.min(height[left], height[right]);
      int width = right - left;
      int currentArea = length * width;
      maxArea = Math.max(maxArea, currentArea);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxArea;
  }
}

