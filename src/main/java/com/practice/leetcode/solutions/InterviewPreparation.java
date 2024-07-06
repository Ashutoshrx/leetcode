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
}
