package com.practice.leetcode.solutions;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringSolutions {

  public static void lengthOfLastWord(String s) {
    String[] s1 = s.split(" ");
    System.out.println(s1[s1.length - 1].length());
  }

  public static void isPalindrome(String s) {
    System.out.println("original text:" + s);
    char ch;
    String newString = "";
    String split = s.replaceAll("[^a-zA-Z0-9\\\\s]+", "").toLowerCase().replace("\\", "");
    System.out.println(split);
    for (int i = 0; i < split.length(); i++) {
      ch = split.charAt(i);
      newString = ch + newString;
    }
    System.out.println(split.length() > 1 && newString.equalsIgnoreCase(split));
  }

  public static void isValid(String s) {
    System.out.println("Original brackets:" + s);
    String a = s.replaceAll("[\\\\(\\\\)]", "A");
    String b = a.replaceAll("[\\[\\]]", "B");
    String c = b.replaceAll("[\\\\{\\\\}]", "C");
    System.out.println(c);
  }

  public static void playWithArrays(int number) {
    List<Integer> integers = Arrays.asList(23, 45, 12, 34, 76);
    Set<Set<Integer>> x = new HashSet<>();
    int target;
    for (int i : integers) {
      target = number - i;
      if (integers.contains(target)) {
        x.add(Set.of(target, i));
      }
    }
    System.out.println(x.stream().flatMap(Set::stream).toList());
  }

  public static void longestSubString(List<Integer> numbers, int target) {
    HashSet<Integer> set = new HashSet<>(numbers);
    HashSet<HashSet<Integer>> test = new HashSet<>();
    set.forEach(x -> {
      if (set.contains(target - x)) {
        HashSet<Integer> output = new HashSet<>();
        output.add(x);
        output.add(target - x);
        test.add(output);
      }
    });
    System.out.println(test);
  }

  public static void reverse(String input) {
    StringBuilder reverse = new StringBuilder();
    for (int i = input.length() - 1; i > -1; i--) {
      reverse.append(input.charAt(i));
    }
    System.out.println(reverse);
  }

  public static void printSecondLargest(List<Integer> numbers) {
    System.out.println(numbers);
    Collections.sort(numbers);
    System.out.println(numbers);
    System.out.println(numbers.get(1));
  }

  //1234567 2
  public static int binarySearch(int[] items, int target) {
    int left = 0;
    int right = items.length - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if (items[mid] == target) {
        return mid;
      } else if (items[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    return -1;
  }

  public static int[] bubbleSort(int[] items) {
    for (int i = 0; i < items.length; i++) {
      for (int j = 0; j < items.length - 1; j++) {
        if (items[j] > items[j + 1]) {
          items[j + 1] = items[j] + items[j + 1];
          items[j] = items[j + 1] - items[j];
          items[j + 1] = items[j + 1] - items[j];
        }
      }
    }
    return items;
  }

  //[6,5,2,8,9,4]
  public static int[] selectionSortMin(int[] items) {
    for (int i = 0; i < items.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < items.length; j++) {
        if (items[j] < items[minIndex]) {
          minIndex = j;
        }
      }
      int temp = items[i];
      items[i] = items[minIndex];
      items[minIndex] = temp;
    }
    return items;
  }

  public static int[] selectionSortWithMax(int[] items) {
    int len = items.length;
    for (int i = len - 1; i > 0; i--) {
      int maxIndex = i;
      for (int j = 0; j < i; j++) {
        if (items[j] > items[maxIndex]) {
          maxIndex = j;
        }
      }
      System.out.println(items[maxIndex]);
      int temp = items[i];
      items[i] = items[maxIndex];
      items[maxIndex] = temp;
    }
    return items;
  }

  public static int[] rotateArray(int[] items, int k) {
    int length = items.length;
    int[] A = reverse(items, 0, (length - 1) - k);
    reverse(A, length - k, length - 1);
    return reverse(A, 0, length - 1);
  }


  public static int[] reverse(int[] items, int leftIndex, int rightIndex) {
    while (leftIndex < rightIndex) {
      int temp = items[leftIndex];
      items[leftIndex] = items[rightIndex];
      items[rightIndex] = temp;
      leftIndex++;
      rightIndex--;
    }
    return items;
  }

  public static int[] hello(int[] items) {
    for (int i = 1; i < items.length; i++) {
      int key = items[i];
      int j = i - 1;
      while (j >= 0 && items[j] > key) {
        items[j + 1] = key;
        j--;
      }
      items[j + 1] = key;
    }
    return items;
  }

  /*
  1 3 5 6 - 5 # 2
  1 3 5 6 - 2 # 1
  */
  public static int searchInsertPosition(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int mid = 0;
    while (left <= right) {
      mid = (left + right) / 2;
      if (target == nums[mid]) {
        return mid;
      } else if (target > nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    System.out.println("LEFT:" + left);
    System.out.println("MID:" + mid);
    System.out.println("RIGHT:" + right);
    if (mid == nums.length - 1 || mid <= 1) {
      return left;
    }
    return mid;
  }

  /*1 2 3 --- 1 2 4*/
  public static int[] plusOne(int[] digits) {
    StringBuilder num = new StringBuilder();
    for (int i : digits) {
      num.append(i);
    }
//    BigInteger guess = new BigInteger(num.toString()).add(new BigInteger("1"));
    BigInteger guess = new BigInteger(num.toString()).add(BigInteger.ONE);
    String temp = String.valueOf(guess);
    int[] newGuess = new int[temp.length()];
    for (int i = 0; i < temp.length(); i++) {
      newGuess[i] = temp.charAt(i) - '0';
    }
    return newGuess;
  }

  public static int[] plusOnePartTwo(int[] digits) {
    System.out.println("Input:" + Arrays.toString(digits));
    for (int i = digits.length - 1; i > 0; i--) {
      if (digits[i] < 9) {
        digits[i] += 1;
        return digits;
      }
      digits[i] = 0;
    }
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }

  //TODO
    /* public static String excelSheetColumnTitle(int columnNumber) {
    StringBuilder s = new StringBuilder();
    while (columnNumber > 0) {
      int remainder = (columnNumber - 1) % 26;
      System.out.println(remainder);
      s.append((char) remainder);

      if (remainder == 0) {
        break;
      }
    }
    return s.toString();
  }*/

  /**
   * ()->true
   * (]- false
   * (){}[]->true
   **/
  public static boolean isValidParenthesis(String s) {
    Stack<Character> characters = new Stack<>();
    if (s.isEmpty()) {
      return true;
    }
    for (int i = 0; i < s.length(); i++) {
      System.out.println("Element:" + s.charAt(i));
      if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
        characters.push(s.charAt(i));
      } else {
        if (characters.empty()) {
          return false;
        } else {
          Character pop = characters.pop();
          System.out.println("Popped:" + pop);
          if (!(pop == '(' && s.charAt(i) == ')' || pop == '{' && s.charAt(i) == '}' || pop == '[' && s.charAt(i) == ']')) {
            return false;
          }
        }
      }
    }
    return characters.empty();
  }

  /**
   * @param s
   * @param t
   * @return Problem 844: BackSpace String Compare
   * @Input s = ab#c & t = ad#c
   * @Solution true
   */
  public static boolean backspaceCompare(String s, String t) {
    Stack<Character> temp_s = new Stack<>();
    Stack<Character> temp_t = new Stack<>();
    if (s != null && t != null) {
      for (int i = 0; i < s.length(); i++) {
        if (!temp_s.isEmpty() && s.charAt(i) == '#') {
          temp_s.pop();
        } else {
          if (s.charAt(i) != '#') {
            temp_s.push(s.charAt(i));
          }
        }
      }
      for (int i = 0; i < t.length(); i++) {
        if (!temp_t.isEmpty() && t.charAt(i) == '#') {
          temp_t.pop();
        } else {
          if (t.charAt(i) != '#') {
            temp_t.push(t.charAt(i));
          }
        }
      }
    }
    System.out.println("S:" + temp_s);
    System.out.println("T:" + temp_t);
    return temp_s.equals(temp_t);
  }

  /**
   * @param s
   * @return Problem 678- Valid Parenthesis String
   * @Input (*), (( *), (((*))
   * @Solution true, true, true
   */
  public static boolean checkValidString(String s) {
    int openCount = 0, closeCount = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '*') {
        openCount += 1;
      } else {
        if (openCount > 0) {
          openCount -= 1;
        } else {
          return false;
        }
      }
    }
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ')' || s.charAt(i) == '*') {
        closeCount += 1;
      } else {
        if (closeCount > 0) {
          closeCount -= 1;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * @param s
   * @return Problem 1249- Minimum Remove to Make Valid Parentheses
   * @Input a)b(c)d,lee(t(c)o)de),))((
   * @Solution ab(c)d, leet(t(c)o)de,null
   */
  public static String minRemoveToMakeValid(String s) {
    StringBuilder result = new StringBuilder();
    Stack<Integer> temp = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        System.out.println("index1:" + i);
        System.out.println("index2:" + result.length());
        temp.push(result.length());
        result.append(s.charAt(i));
      } else if (s.charAt(i) == ')') {
        if (!temp.isEmpty()) {
          temp.pop();
          result.append(s.charAt(i));
        }
      } else {
        result.append(s.charAt(i));
      }
    }
    System.out.println("first iteration:" + result);
    System.out.println("stack:" + temp);
    while (!temp.isEmpty()) {
      Integer pop = temp.pop();
      result.deleteCharAt(pop);
    }
    return result.toString();
  }

  /**
   * @param students
   * @param sandwiches
   * @return Problem 1700: Number of students unable to eat lunch
   * @Input students=[1, 1, 0, 0] & sandwiches=[0, 1, 0, 1]
   * @Solution 0 student
   * @Input students=[1, 1] & sandwiches=[0, 1]
   * @Solution 2 students
   */
  public static int countStudents(int[] students, int[] sandwiches) {
    Map<Integer, Integer> studentMap = new HashMap<>();
    int length = students.length;
    for (int student : students) {
      studentMap.put(student, studentMap.getOrDefault(student, 0) + 1);
    }
    System.out.println(studentMap);
    for (int sandwich : sandwiches) {
      if (studentMap.get(sandwich) != null && studentMap.get(sandwich) > 0) {
        length -= 1;
        studentMap.put(sandwich, studentMap.get(sandwich) - 1);
      } else {
        return length;
      }
    }
    return length;
  }

  /**
   * @param tickets
   * @param k
   * @return Problem: 2073
   * @Input tickets=[2,3,2],k=2
   * @Solution 6 seconds
   * @Input tickets=[5,1,1,1],k=0
   * @Solution 8
   */
  public static int timeRequiredToBuy(int[] tickets, int k) {
    int time = 0;
    for (int i = 0; i < tickets.length; i++) {
      if (i <= k) {
        time += Math.min(tickets[i], tickets[k]);
      } else {
        time += Math.min(tickets[i], tickets[k] - 1);
      }
    }
    return time;
  }

  public static String makeGood(String s) {
    for (int i = 0; i < s.length() - 1; i++) {
      System.out.println((int) s.charAt(i));
      if ((int) s.charAt(i) - (int) s.charAt(i + 1) == 32 || (int) s.charAt(i + 1) - (int) s.charAt(i) == 32) {
        return makeGood(s.substring(0, i) + s.substring(i + 2));
      }
    }
    return s;
  }

  /**
   * @param deck
   * @return Problem 950: Reveal Cards in increasing Order
   * @Input [17, 13, 11, 2, 3, 5, 7]
   * @Solution [2, 13, 3, 11, 5, 17, 7]
   */
  public static int[] deckRevealedIncreasing(int[] deck) {
    Arrays.sort(deck);
    int length = deck.length;
    int[] res = new int[length];
    Queue<Integer> queue = IntStream.range(0, length).boxed().collect(Collectors.toCollection(LinkedList::new));
    for (int i = 0; i < length - 1; i++) {
      System.out.println("Peek:" + queue.peek());
      res[queue.poll()] = deck[i];
      queue.add(queue.poll());
      System.out.println("Test:" + Arrays.toString(res));
    }
    res[queue.peek()] = deck[length - 1];
    return res;
  }

  /**
   * @param num
   * @param k
   * @return Problem 402; Remove K digits
   * @Input num=14332219, k=3
   * @Solution 1219
   */

  public static String removeKDigits(String num, int k) {
    Stack<Character> res = new Stack<>();
    for (int i = 0; i < num.length(); i++) {
      if (res.isEmpty() && num.charAt(i) > '0') {
        res.push(num.charAt(i));
      } else {
        if (res.peek() < num.charAt(i)) {
          res.push(num.charAt(i));
        } else {
          if (k > 0) {
            res.pop();
            k -= 1;
            if (num.charAt(i) > '0') {
              res.push(num.charAt(i));
            }
          } else {
            res.push(num.charAt(i));
          }
        }
      }
    }
    System.out.println(res);
    StringBuilder output = new StringBuilder();
    while (!res.isEmpty()) {
      output.append(res.pop());

    }
    if (output.isEmpty()) {
      return "0";
    }
    return output.reverse().toString();
  }

  public static String removeKDigitsTest(String num, int k) {
    Stack<Character> resultStack = new Stack<>();

    for (int i = 0; i < num.length(); i++) {
      char currentDigit = num.charAt(i);

      while (!resultStack.isEmpty() && k > 0 && resultStack.peek() > currentDigit) {
        resultStack.pop();
        k--;
      }

      resultStack.push(currentDigit);
    }

    // Remove leading zeros
    StringBuilder output = new StringBuilder();
    while (!resultStack.isEmpty() && resultStack.peek() == '0') {
      resultStack.pop();
    }

    // Construct result string
    while (!resultStack.isEmpty()) {
      output.append(resultStack.pop());
    }

    // Handle case where all digits are removed
    if (output.length() == 0) {
      return "0";
    }

    return output.reverse().toString();
  }

  /**
   * @param height
   * @return Problem 42: Trapping Rain Water
   * @Input [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
   * @Solution 6
   */
  public static int trap(int[] height) {
    int length = height.length, sum = 0, left = 0, right = length - 1, maxLeft = height[left], maxRight = height[right];
    while (left < right) {
      if (maxLeft <= maxRight) {
        left++;
        maxLeft = Math.max(height[left], maxLeft);
        System.out.println("maxLeft:" + maxLeft + "," + height[left]);
        sum += Math.max(maxLeft - height[left], 0);
//        System.out.println(maxLeft);
      } else {
        right--;
        maxRight = Math.max(height[right], maxRight);
        System.out.println("maxRight:" + maxRight + "," + height[right]);
        sum += Math.max(maxRight - height[right], 0);
//        System.out.println(maxRight);
      }
    }
    System.out.println("Total sum:" + sum);
    return sum;
  }

  public static int trapWithNSpaceComplexity(int[] height) {
    int length = height.length, left = 0, right = length - 1, maxLeft = height[left], maxRight = height[right];
    int[] maxLeftArr = new int[length];
    int[] maxRightArr = new int[length];
    for (int i = 0; i < length - 1; i++) {
      maxLeft = Math.max(height[i], maxLeft);
      maxLeftArr[i] = maxLeft;
    }
    for (int i = length - 1; i >= 0; i--) {
      maxRight = Math.max(height[i], maxRight);
      maxRightArr[i] = maxRight;
    }
    int x = 0, sum = 0;
    while (x < length) {
      sum += Math.max(Math.min(maxLeftArr[x], maxRightArr[x]) - height[x], 0);
      x++;
    }

//    System.out.println(Arrays.toString(maxLeftArr));
//    System.out.println(Arrays.toString(maxRightArr));
    return sum;
  }

  public static int findSecondMaximum(int[] array) {
    int min = array[0], secondMin = array[0];
    for (int i : array) {
      if (i < min) {
        secondMin = min;
        min = i;
      }
    }
    System.out.println(min);
    return secondMin;
  }

  /**
   * @param word
   * @param ch
   * @return Problem 2000: Reverse Prefix of a word
   */
  public static String reversePrefix(String word, char ch) {
    int found = word.indexOf(ch);
    return new StringBuilder().append(word.substring(0, found + 1)).reverse().append(word.substring(found + 1)).toString();

  }

  public static String removeTrailingZeros(String num) {
    int found = 0;
    for (int i = num.length() - 1; i >= 0; i--) {
      System.out.println(num.charAt(i));
      if (num.charAt(i) != '0') {
        found = i;
        break;
      }
    }
    System.out.println(found);
    return num.substring(0, found + 1);
  }

  /**
   * @param nums
   * @return Problem:2441 Largest Positive Integer
   * @Input [-1, 10, 6, 7, -7, 1]
   */
  public static int findMaxK(int[] nums) {
    Arrays.sort(nums);
    int i = 0, j = nums.length - 1;
    while (j >= i) {
      if (Math.abs(nums[j]) == Math.abs(nums[i])) {
        return nums[j];
      } else if (Math.abs(nums[j]) < Math.abs(nums[i])) {
        i++;
      } else if (Math.abs(nums[j]) > Math.abs(nums[i])) {
        j--;
      }
    }
    return -1;
  }

  /**
   * @param s
   * @param t
   * @return
   */
  public static boolean isAnagram(String s, String t) {
    Map<Character, Integer> sMap = new HashMap<>();
    if (s.length() != t.length()) {
      return false;
    }
    for (int i = 0; i < s.length(); i++) {
      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
      sMap.put(t.charAt(i), sMap.getOrDefault(t.charAt(i), 0) - 1);
    }
    for (int i : sMap.values()) {
      if (i > 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * @param s
   * @param p
   * @return Problem: 10 Regular Expression Matching
   */
  public static boolean isMatch(String s, String p) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      stack.add(s.charAt(i));
    }
    System.out.println("Initial:" + stack);
    for (int i = p.length() - 1; i >= 0; i--) {
      Character pop = stack.pop();
      char curr = p.charAt(i);
      if (pop != curr && '.' != curr || '*' != curr) {
        return false;
      }
    }
    System.out.println(stack);
    return stack.isEmpty();
  }

  /**
   * @param a
   * @param b
   * @return Problem: 67
   * @Input 11{1011} & 1{0001}= 12{1100}
   */
  public static String addBinary(String a, String b) {
    a = Integer.toBinaryString(Integer.parseInt(a));
    b = Integer.toBinaryString(Integer.parseInt(b));
    System.out.println(a);
    return "";
  }

  public static int singleNumber_notBetterApproach(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    System.out.println(map);
    return map.entrySet().stream().filter(x -> x.getValue().equals(1))
            .map(Map.Entry::getKey).findFirst().orElse(0);
  }

  public static int singleNumber(int[] nums) {
//    4, 1, 2, 1, 2 {0100,0001,0010,0010}====0000
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }
    return result;
  }

  /**
   * @param n
   * @param time
   * @return Problem 2562: Pass the pillow
   */
  public static int passThePillow(int n, int time) {
    var direction = 1;
    int currentPerson = 1;
    while (time > 0) {
      currentPerson += direction;
      if (currentPerson == n || currentPerson == 1) {
        direction = direction * -1;
      }
      time--;
    }
    return currentPerson;
  }
}