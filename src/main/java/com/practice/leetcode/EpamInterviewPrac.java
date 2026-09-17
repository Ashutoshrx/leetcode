package com.practice.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EpamInterviewPrac {
  public static void main(String[] args) {
    // 1.Reverse the array of characters.
    char[] reverseArray = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
//    var res = reverseArrayOfCharacters(reverseArray);
    //2 group words by first letter
    /*Map<Character, List<String>> res = groupWordsByFirstLetter(
            List.of("Ashutosh", "satapathy", "ananya", "Sushree"));*/
    //3.find duplicate elements
//    var res = findDuplicateElements(new int[]{1, 1, 2, 3, 4, 5, 5});
    //4. Move zeroes to right
//    var res = moveZeroes(new int[]{0, 1, 0, 3, 12});
//    var res = findSecondHighesWord("Mera naam hai Ashutosh Satapathy");
//    var res = findSecondHighestLength("Mera naam hai Ashutosh Satapathy");
    //5. Find the missing number in a sequence of 1-n. JAVA steams
//    var res = findMissingNumber(new int[]{1, 2, 3, 4, 5, 8, 9, 10, 11, 12, 13, 14});
//    var res = findMissingNumber(new int[]{1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14});
    //6. Calculate sum of the current element and upto the previous k-1 elements
//    slidingWindow(new int[]{1, 2, 3, 4, 5, 6}, 3);
    //7. Find a duplicate number in a sequence from 1-n.
//    var res = findDuplicateNumber(new int[]{7, 3, 4, 4, 5, 6, 7});
//    8. Convert sentence to hashtag
//    String res = convertStringToHashtag("java 8 streams are powerful");
    String res = convertStringToHashtag("Hello World");
//    9. Java-8- Filter palindrome words
//    List<String> res = filterPalindromeWords("madam java level code radar");
//    10. Merge two sorted integer arrays into a single sorted array.
//    int[] res = mergerTwoSortedArray(new int[]{1, 2, 3}, new int[]{2, 5, 6});
//    11. Filter out only the valid integers from a list of strings
//    List<Integer> res = validIntegers(List.of("10", "abc", "20", "hello", "30"));
//    System.out.println(Arrays.toString(res));
    System.out.println(res);
  }

  /**
   * @param reverseArray
   * @return Problem:1 Reverse the array of characters
   */
  private static char[] reverseArrayOfCharacters(char[] reverseArray) {
    int length = reverseArray.length;
    int last = length - 1;
    for (int i = 0; i < length / 2; i++) {
      char temp = reverseArray[i];
      reverseArray[i] = reverseArray[last - i];
      reverseArray[last - i] = temp;
    }
    return reverseArray;
  }

  /**
   * @param inputArray
   * @return group words by first letter
   */
  private static Map<Character, List<String>> groupWordsByFirstLetter(List<String> inputArray) {
    return inputArray.stream().map(String::toLowerCase).
            collect(Collectors.groupingBy(letter -> letter.charAt(0)));
  }

  /**
   * @param inputArray
   * @return find duplicate elements
   */
  private static List<Integer> findDuplicateElements(int[] inputArray) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : inputArray) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    System.out.println(map);
//    return map.entrySet().stream().filter(x -> x.getValue() > 1).map(Map.Entry::getKey).toList();
    Set<Integer> set = new HashSet<>();
    return Arrays.stream(inputArray).filter(value -> !set.add(value)).boxed().toList();
  }

  /**
   * @param array
   * @return Move zeroes to right
   */
  private static int[] moveZeroes(int[] array) {
    System.out.println(Arrays.toString(array));
    int left = 0, right = 0;
    while (right < array.length) {
      if (array[right] != 0) {
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;
        left++;
      }
      right++;
    }
    return array;
  }

  /**
   * @param sentence
   * @return Find the second highest length in a given sentence of words using java 8 streams
   */
  private static Integer findSecondHighestLength(String sentence) {
    String[] words = sentence.split(" ");
    return Arrays.stream(words).map(String::length).
            sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
  }

  /**
   * @param sequence
   * @return Find the missing number in a sequence of 1-n. JAVA steams
   */
  private static int findMissingNumber(int[] sequence) {
    System.out.println(Arrays.toString(sequence));
    int max = Arrays.stream(sequence).max().orElse(0);
    List<Integer> res = new ArrayList<>();
    // @TODO NOT CORRECT LOGIC- FIX THIS
    int j = 0;
    for (int i = 1; i < max; i++) {
      if (i != sequence[j]) {
        res.add(i);
        i++;
      } else {
        j++;
      }
    }
    System.out.println(res);
    //approach 2
    int expectedSum = IntStream.rangeClosed(1, max).sum();
    int actualSum = Arrays.stream(sequence).sum();
    return expectedSum - actualSum;
  }

  /**
   * @param array
   * @param k
   * @returns Calculate sum of the current element and upto the previous k-1 elements
   */
  private static void slidingWindow(int[] array, int k) {
    System.out.println(Arrays.toString(array));
    List<Integer> sums = new ArrayList<>();
    int i = 0;
    int currentSum = 0;
    for (; i < k; i++) {
      currentSum += array[i];
    }
    sums.add(currentSum);
    System.out.println(currentSum);
    for (i = k; i < array.length; i++) {
      currentSum += array[i];
      currentSum -= array[i - k];
      sums.add(currentSum);
    }
    System.out.println(sums);
  }

  /**
   * @param array
   * @return Find a duplicate number in a sequence from 1-n.
   */
  private static int[] findDuplicateNumber(int[] array) {
    HashSet<Integer> set = new HashSet<>();
    return Arrays.stream(array).filter(n -> !set.add(n)).toArray();
  }

  /**
   * @param sentence
   * @return Convert sentence to hashtag
   * @Input hello world-> #HelloWorld
   */
  private static String convertStringToHashtag(String sentence) {
    //APPROACH-1
    /*StringBuilder res = new StringBuilder();
    String[] words = sentence.split(" ");
    res.append("#");
    for (String word : words) {
      res.append(word.toUpperCase().charAt(0)).append(word.toLowerCase().substring(1));
    }
    return res.toString();*/
    //APPROACH-2
    return Arrays.stream(sentence.split(" ")).
            map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase()).
            collect(Collectors.joining("", "#", ""));

  }

  /**
   * @param sentence
   * @return Java-8- Filter palindrome words
   */
  private static List<String> filterPalindromeWords(String sentence) {
    System.out.println(sentence);
/*    return Arrays.stream(sentence.split(" ")).filter(word ->
            new StringBuilder(word).reverse().toString().equals(word)).toList();*/
    // TODO Solve is using IntStream
    return null;
  }

  /**
   * @param array1
   * @param array2
   * @return Merge two sorted integer arrays into a single sorted array.
   */
  private static int[] mergerTwoSortedArray(int[] array1, int[] array2) {
    int[] res = new int[array1.length + array2.length];
    int i = 0, j = 0, index = 0;
    while (i < array1.length && j < array2.length) {
      System.out.println(array1[i]);
      System.out.println(array2[j]);
      if (array1[i] >= array2[j]) {
        res[index] = array2[j];
        j++;
      } else {
        res[index] = array1[i];
        i++;
      }
      index++;
    }
    while (i < array1.length) {
      res[index++] = array1[i];
      i++;
    }
    while (j < array2.length) {
      res[index++] = array2[j];
      j++;
    }
    return res;
  }

  /**
   * @param input
   * @return Filter out only the valid integers from a list of strings
   */
  private static List<Integer> validIntegers(List<String> input) {
    List<Integer> res = new ArrayList<>();
    for (String s : input) {
      if (isValidInteger(s)) {
        res.add(Integer.parseInt(s));
      }
    }
    return res;
  }

  private static boolean isValidInteger(String value) {
    try {
      Integer.parseInt(value);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private static String findSecondHighesWord(String sentence) {
    String[] words = sentence.split(" ");
    return Arrays.stream(words).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().orElse(null);
  }
}