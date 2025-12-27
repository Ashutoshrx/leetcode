package com.practice.leetcode.solutions;

import java.util.*;

public class InterviewPreparation {
  /**
   * @param nums
   * @return
   * @Input [0, 0, 1, 1, 1, 2, 2, 3, 3, 4,5]
   */
  public static int removeDuplicates(int[] nums) {
    /*int i = 0, j=1;
    while (j < nums.length) {
      if (nums[i] == nums[j]) {
        j++;
      } else {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;*/
    int i = 0;
    for (var j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    System.out.println(Arrays.toString(nums));
    return i + 1;
  }

  /**
   * @param s
   * @return
   * @Input [7, 1, 5, 3, 6, 4]
   */
  public static int scoreOfString(String s) {
    int sum = 0;
    int j = 0;
    for (int i = 1; i < s.length(); i++) {
      int diff = ((char) s.charAt(i)) - (char) s.charAt(j);
      sum += Math.abs(diff);
      j++;
    }
    return sum;
  }

  public static void removeDuplicatesAndStore(List<Integer> nums) {
    Set<Integer> newSet = new HashSet<>();
    for (var num : nums) {
      if (newSet.add(num)) {
        newSet.add(num);
      }
    }
    System.out.println(newSet);
  }

  public static Character firstRepeatingCharacter(String input) {
    Map<Character, Integer> map = new HashMap<>();
    for (var i = 0; i < input.length(); i++) {
      char current = input.charAt(i);
      map.put(current, map.getOrDefault(current, 0) + 1);
      if (map.get(current) > 1) {
        return current;
      }
    }
    System.out.println(map);
    return null;
  }

  /*
  sort a list of string based on their length
   */
  public static List<String> sortBasedOnStringSize(List<String> names) {
    names.sort((a, b) -> (a.length() >= b.length()) ?
            1 : -1);
    return names;
  }

  public static void removeConsecutiveLetters(String data) {
    System.out.println(data);
//    System.out.println(data.replaceAll("[^a-zA-z0-9]","#"));
//    System.out.println(data.replaceAll("\\D","#"));
//    System.out.println(data.replaceAll(" ","#"));
//    System.out.println(data.replaceAll("\\s{2}",""));
    Set<String> x = new HashSet<>();
    String previous;
    do {
      previous = data;
      System.out.println("Inside");
      data = data.replaceAll("(.)\\1", "$1");
    } while (!data.equals(previous));
    System.out.println(data);
//    System.out.println(data.replaceAll("(+)\\1", "$1"));

  }

  public static boolean isAnagram(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    if (s.length() != t.length()) {
      return false;
    }
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
    }
    for (var i : map.values()) {
      if (i > 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * @param nums
   * @param k    Problem:189: Rotate Array:
   */
  public static void rotate(int[] nums, int k) {
    int length = nums.length;
    reverseNumbers(nums, 0, k);
    reverseNumbers(nums, k + 1, length - 1);
    reverseNumbers(nums, 0, length - 1);
    System.out.println(Arrays.toString(nums));
  }

  private static void reverseNumbers(int[] nums, int startIndex, int endIndex) {
    while (startIndex < endIndex) {
      nums[startIndex] = nums[startIndex] ^ nums[endIndex];
      nums[endIndex] = nums[endIndex] ^ nums[startIndex];
      nums[startIndex] = nums[startIndex] ^ nums[endIndex];
      startIndex++;
      endIndex--;
    }
  }

  /**
   * @param nums
   * @return Problem: 53: maximum subarray
   * Kaden's Algorithm
   */
  public static int maxSubArray(int[] nums) {
    int maxSubSum = Integer.MIN_VALUE, currentSum = 0;
    for (int i : nums) {
      currentSum += i;
      maxSubSum = Math.max(currentSum, maxSubSum);
      currentSum = Math.max(0, currentSum);
    }
    return maxSubSum;
  }

  /**
   * @param nums
   * @param k
   * @return Problem: 239, Sliding window Maximum
   */
  public static int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    Deque<Integer> deque = new ArrayDeque<>();
    int[] res = new int[n - k + 1];
    int left = 0, index = 0, right = 0;
    while (right < n) {
      while (!deque.isEmpty() && nums[right] >= nums[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.offer(right);
      System.out.println(deque);

      if (right + 1 >= k) {
        res[index++] = nums[deque.peekFirst()];
        left++;
      }
      if (left > deque.peekFirst()) {
        deque.pollFirst();
      }
      right++;
    }
    return res;
  }

  /**
   * @param nums
   * @param k
   * @return Problem: 643: Maximum Average SubArray 1
   */
  public static double findMaxAverage(int[] nums, int k) {
    int maxSum = 0;
    int i = 0;
    for (; i < k; i++) {
      maxSum += nums[i];
    }
    double maxAvg = maxSum / (double) k;
    for (; i < nums.length; i++) {
      maxSum -= nums[i - k];
      maxSum += nums[i];
      maxAvg = Math.max(maxAvg, maxSum / (double) k);
    }
    return maxAvg;
  }

  /**
   * @param nums
   * @return 238. Product of Array Except Self
   */
  public static int[] productExceptSelf(int[] nums) {
    System.out.println(Arrays.toString(nums));
    int length = nums.length;
    int[] prefixSum = new int[length];
    int product = 1;
    for (int i = 0; i < length; i++) {
      product *= nums[i];
      prefixSum[i] = product;
    }
    System.out.println(Arrays.toString(prefixSum));
    product = 1;
    int[] postfix = new int[length];
    for (int i = length - 1; i >= 0; i--) {
      product *= nums[i];
      postfix[i] = product;
    }
    System.out.println(Arrays.toString(postfix));
    nums[0] = postfix[1];
    nums[length - 1] = prefixSum[length - 2];
    for (int i = 1; i < length - 1; i++) {
//      System.out.println("i,arr[i]: " + i + ":" + prefixSum[i - 1] * postfix[i + 1]);
      nums[i] = prefixSum[i - 1] * postfix[i + 1];
    }
    return nums;
  }

  /**
   * @param nums
   * @return Problem:15 3Sum
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int threeSum = nums[i] + nums[left] + nums[right];
        if (threeSum == 0) {
          res.add(List.of(nums[i], nums[left], nums[right]));
          left++;
          while (nums[left] == nums[left - 1] && left < right) {
            left++;
          }
        } else if (threeSum > 0) {
          right--;
        } else {
          left++;
        }
      }
    }
    return res;
  }

  /**
   * @param nums
   * @Problem: 283: Move Zeroes
   * @Input [0, 1, 0, 3, 12]
   * @output [[1, 12, 3, 0, 0]]
   */
  public static void moveZeroes(int[] nums) {
    int i = 0, zero = 0;
    while (i < nums.length) {
      if (nums[i] != 0) {
        int temp = nums[i];
        nums[i] = nums[zero];
        nums[zero] = temp;
        zero++;
      }
      i++;
    }
    System.out.println(Arrays.toString(nums));
  }

  /**
   * @param customers
   * @return Problem: 2483- Minimum Penalty for a shop
   * @Approach- PrefixSum
   */
  public static int bestClosingTime(String customers) {
    System.out.println(Arrays.toString(customers.split("")));
    //Y Y N Y
    //0 0 0 1 1
    //3 2 1 1 0
    int minPenalty = Integer.MAX_VALUE, index = 0;
    int n = customers.length();
    int[] prefixN = new int[n + 1];
    int[] postY = new int[n + 1];
    for (int j = 1; j < n + 1; j++) {
      System.out.println("custX: " + customers.charAt(j - 1));
      prefixN[j] = prefixN[j - 1];
      if (customers.charAt(j - 1) == 'N') {
        prefixN[j]++;
      }
    }
    for (int j = n - 1; j >= 0; j--) {
      System.out.println("custY: " + customers.charAt(j));
      postY[j] = postY[j + 1];
      if (customers.charAt(j) == 'Y') {
        postY[j]++;
      }
    }
    System.out.println(Arrays.toString(prefixN));
    System.out.println(Arrays.toString(postY));
    for (int i = 0; i < prefixN.length; i++) {
      int currentSum = prefixN[i] + postY[i];
      if (currentSum < minPenalty) {
        minPenalty = currentSum;
        index = i;
      }
    }
    return index;
  }

}