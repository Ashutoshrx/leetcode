package com.practice.leetcode.solutions;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringSolutions {

  static Map<Integer, String> onesMap = new HashMap<>() {
    {
      put(1, "One");
      put(2, "Two");
      put(3, "Three");
      put(4, "Four");
      put(5, "Five");
      put(6, "Six");
      put(7, "Seven");
      put(8, "Eight");
      put(9, "Nine");
      put(10, "Ten");
      put(11, "Eleven");
      put(12, "Twelve");
      put(13, "Thirteen");
      put(14, "Fourteen");
      put(15, "Fifteen");
      put(16, "Sixteen");
      put(17, "Seventeen");
      put(18, "Eighteen");
      put(19, "Nineteen");
    }
  };
  static Map<Integer, String> tensMap = new HashMap<>() {
    {
      put(20, "Twenty");
      put(30, "Thirty");
      put(40, "Forty");
      put(50, "Fifty");
      put(60, "Sixty");
      put(70, "Seventy");
      put(80, "Eighty");
      put(90, "Ninety");
    }
  };

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
    for (int i = digits.length - 1; i >= 0; i--) {
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
    return new StringBuilder().append(word, 0, found + 1).reverse().append(word.substring(found + 1)).toString();

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
    return map.entrySet().stream().filter(x -> x.getValue().equals(1)).map(Map.Entry::getKey).findFirst().orElse(0);
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

  /**
   * @param numBottles
   * @param numExchange
   * @return Problem:1518 Water bottles
   */
  public static int numWaterBottles(int numBottles, int numExchange) {
    int res = numBottles;
    while (numBottles >= numExchange) {
      int newBottles = numBottles / numExchange;
      numBottles = newBottles + (numBottles % numExchange);
      res += newBottles;
    }
    return res;
  }

  /**
   * @param n
   * @param k
   * @return Problem 1823: Find the winner of the game
   */
  public static int findTheWinnerLessEfficient(int n, int k) {
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      queue.add(i);
    }
    int current = 1;
    while (queue.size() > 1) {
      if (current < k) {
        queue.offer(queue.poll());
        current++;
      } else {
        queue.poll();
        current = 1;
      }
    }
    return queue.peek();
  }

  public static int findTheWinner(int n, int k) {
    int winner = 0;
    for (int i = 1; i <= n; i++) {
      winner = (winner + k) % i;
      System.out.println(winner);
    }
    return winner + 1;
  }

  /**
   * @param s
   * @return Problem 1190: Reverse Substring between Each pair of Parenthesis
   */
  /*public static String reverseParentheses(String s) {
    var start = 0;
    var end = 0;
    for (char c : s.toCharArray()) {
      Stack<String> characters = new Stack<>();
      if (c == '(') {
        characters.push()
      }
    }*/

  /**
   * @param s
   * @param x
   * @param y
   * @return Problem 1717: Maximum Scope from removing substring
   */
  public static int maximumGain(String s, int x, int y) {
    int max = Math.max(x, y);
    int min = Math.min(x, y);
    char first = max == x ? 'a' : 'b';
    char second = max == x ? 'b' : 'a';

    int totalPoints = 0;
    Stack<Character> characters = new Stack<>();
    Stack<Character> remaining = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (!characters.isEmpty()) {
        if (characters.peek() == first && s.charAt(i) == second) {
          characters.pop();
          totalPoints += max;
        } else {
          characters.push(s.charAt(i));
        }
      } else {
        characters.push(s.charAt(i));
      }
    }
    System.out.println(characters);
    while (!characters.isEmpty()) {
      Character curr = characters.pop();
      if ((!remaining.isEmpty() && remaining.peek() == first) && curr == second) {
        remaining.pop();
        totalPoints += min;
      } else {
        remaining.push(curr);
      }
    }
    System.out.println(remaining);
    return totalPoints;
  }

  /**
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   * @Problem: 88(Merge two sorted arrays)
   */
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    var p = m + n - 1;
    var i = m - 1;
    var j = n - 1;
    while (j >= 0) {
      if (i >= 0 && nums1[i] > nums2[j]) {
        nums1[p] = nums1[i];
        i--;
      } else {
        nums1[p] = nums2[j];
        j--;
      }
      p--;
    }
    for (int ix : nums1) {
      System.out.print(ix);
    }
    System.out.println("\n");
  }

  /**
   * @param names
   * @param heights
   * @return Problem: 2418: Sort the People
   */
  public static String[] sortPeople(String[] names, int[] heights) {
    int n = names.length;
    Map<Integer, String> mapping = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      mapping.put(heights[i], names[i]);
    }
    Arrays.sort(heights);
    int j = 0;
    for (int i = n - 1; i >= 0; i--) {
      names[j] = mapping.get(heights[i]);
      j++;
    }
    return names;
  }

  /**
   * @param nums
   * @return Problem: 1636. Sort Array by Increasing Frequency
   */
  public static int[] frequencySort(int[] nums) {
    int[] frequencies = new int[nums.length];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    System.out.println(map);
    List<Integer> collect = map.entrySet().stream().sorted((o1, o2) -> {
      int freq = o1.getValue().compareTo(o2.getValue());
      if (freq != 0) {
        return freq;
      } else {
        return o1.getKey().compareTo(o2.getKey()) >= 1 ? -1 : 1;
      }
    }).map(Map.Entry::getKey).toList();
    System.out.println(collect);
    int index = 0;
    for (int i : collect) {
      for (int j = 0; j < map.get(i); j++) {
        frequencies[index++] = i;
      }
    }
    System.out.println(Arrays.toString(frequencies));
    return frequencies;
  }

  /**
   * @param s
   * @return Problem: 1653: Minimum Strings to make string balanced
   */
  public static int minimumDeletions(String s) {
    int count = 0;
    Stack<Character> characters = new Stack<>();
    for (char c : s.toCharArray()) {
      characters.push(c);
    }
    while (!characters.isEmpty()) {
      Character curr = characters.pop();
      if (curr == 'a' && (!characters.isEmpty() && characters.peek() == 'b')) {
        count++;
      }
    }
    return count;
  }

  /**
   * @param target
   * @param arr
   * @return Problem: 1460
   */
  public static boolean canBeEqual(int[] target, int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    if (target.length != arr.length) {
      return false;
    }
    for (int i = 0; i < target.length; i++) {
      map.put(target[i], map.getOrDefault(target[i], 0) + 1);
      map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
    }
    for (int i : map.values()) {
      if (i > 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * @param nums
   * @param n
   * @param left
   * @param right
   * @return Problem:1508
   */
  public static int rangeSum(int[] nums, int n, int left, int right) {
    int len = (n * (n + 1)) / 2;
    long mod = 1000000007L;
    int[] newArr = new int[len];
    int sum = 0, i = 0, j = i, k = 0;
    while (k < len) {
      var internalSum = 0;
      for (int x = i; x <= j; x++) {
        internalSum += nums[x];
      }
      newArr[k] = (int) (internalSum % mod);
      k++;
      j++;
      if (j == n) {
        j = ++i;
      }
    }
    Arrays.sort(newArr);
    System.out.println(Arrays.toString(newArr));
    for (int l = left - 1; l < right; l++) {
      sum += newArr[l];
    }
    return (int) (sum % mod);
  }

  /**
   * @param word
   * @return Problem:3016
   */
  public static int minimumPushes(String word) {
//    @TODO
    var cost = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (char c : word.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    return 0;
  }

  /**
   * @param num
   * @return Problem: 273- Integer to English words
   */
  public static String numberToWords(int num) {
    List<String> res = new ArrayList<>();
    if (num == 0) {
      return "Zero";
    }
    /*int i = 0;
    while (num > 0) {
      String[] arr = new String[]{" Thousand", " Million", " Billion"};
      var digit = num % 1000;
      var dig = num / 1000;
      res.add(numberToWordConverter(dig));
      res.add(arr[i]);
      res.add(numberToWordConverter(digit));
      i++;
      num /= 1000;
    }*/
    return numberToWordConverter(num);
//    return String.join(" ", res);
  }

  private static String numberToWordConverter(int num) {
    List<String> res = new ArrayList<>();
    while (num > 10) {
      if (num < 19) {
        return onesMap.get(num);
      } else if (num < 100 && num > 20) {
        var dig = num % 10;
        num /= 10;
        res.add(tensMap.get(num * 10));
        res.add(onesMap.get(dig));
      } else {
        res.add(onesMap.get(num / 100));
        res.add("Hundred");
        num %= 100;
      }
    }
    return String.join(" ", res);
  }

  /**
   * @param original
   * @param m
   * @param n
   * @return Problem: 2022: Convert 1D array to 2D array
   */
  public static int[][] construct2DArray(int[] original, int m, int n) {
    if (m * n != original.length) {
      return new int[0][0];
    }
    int[][] res = new int[m][n];
    int row = 0, col = 0;
    for (int i : original) {
      if (col >= n) {
        col = 0;
        row++;
      }
      res[row][col++] = i;
    }
    return res;
  }

  /**
   * @param nums1
   * @param nums2
   * @return Problem: 4: Median of Two Sorted Arrays
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int i = 0, j = 0;
    int totalLength = nums1.length + nums2.length;
    int firstPosition = totalLength / 2;
    int firstPositionVal = 0;
    int secondPosition = totalLength / 2 - 1;
    int secondPositionVal = 0;
    int index = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        if (firstPosition == index) {
          firstPositionVal = nums1[i];
        }
        if (secondPosition == index) {
          secondPositionVal = nums1[i];
        }
        i++;
      } else {
        if (firstPosition == index) {
          firstPositionVal = nums2[j];
        }
        if (secondPosition == index) {
          secondPositionVal = nums2[j];
        }
        j++;
      }
      index++;
    }
    while (i < nums1.length) {
      if (firstPosition == index) {
        firstPositionVal = nums1[i];
      }
      if (secondPosition == index) {
        secondPositionVal = nums1[i];
      }
      i++;
      index++;
    }
    while (j < nums2.length) {
      if (firstPosition == index) {
        firstPositionVal = nums2[j];
      }
      if (secondPosition == index) {
        secondPositionVal = nums2[j];
      }
      j++;
      index++;
    }
    return totalLength % 2 != 0 ? firstPositionVal :
            (double) (firstPositionVal + secondPositionVal) / 2;

  }

  /**
   * @param chalk
   * @param k
   * @return Problem: 1894: Find the student that will replace the chalk
   */
  public static int chalkReplacer(int[] chalk, int k) {
    int sum = Arrays.stream(chalk).reduce(0, Integer::sum);
    int remainingChalk = k % sum;
    for (int studentIndex = 0; studentIndex < chalk.length; studentIndex++) {
      if (remainingChalk < chalk[studentIndex]) {
        return studentIndex;
      }
      remainingChalk -= chalk[studentIndex];
    }
    return 0;
  }

  /**
   * @param rolls
   * @param mean
   * @param n
   * @return Problem: 2028 Find Missing Observations
   */
  public static int[] missingRolls(int[] rolls, int mean, int n) {
    int[] res = new int[n];
    int k = 0;
    int m = rolls.length;
    int currentSum = Arrays.stream(rolls).reduce(0, Integer::sum);
    int totalSum = mean * (n + m);
    int missingSum = totalSum - currentSum;
    while (n > 0) {
      res[k] = Math.min(Math.min(missingSum, missingSum - n + 1), 6);
      if (res[k] < 0) {
        return new int[0];
      }
      missingSum -= res[k++];
      n--;
    }
    if (missingSum > 0) {
      return new int[0];
    }
    return res;
  }

  public static String[] uncommonFromSentences(String s1, String s2) {
    Map<String, Integer> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    int k = 0;
    for (String i : s1.split(" ")) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    for (String i : s2.split(" ")) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    System.out.println(map);
    for (var entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        res.add(entry.getKey());
      }
    }
    return res.toArray(new String[0]);
  }

  /**
   * @param s
   * @return Problem : 214: Shortest Palindrome
   */
  public static String shortestPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        s = s.charAt(j) + s;
        System.out.println(s);
        i = 0;
        j = s.length() - 1;
      }
      i++;
      j--;
    }
    return s;
  }

  private static boolean isPalindromeRec(String s) {
    int i = 0;
    int length = s.length() - 1;
    while (i < length / 2) {
      if (s.charAt(i++) != s.charAt(length--)) {
        return true;
      }
    }
    return false;
  }

//https://leetcode.com/discuss/general-discussion/460599/blind-75-leetcode-questions

  /**
   * @param nums
   * @param target
   * @return Two Sum Problem: Problem:1,{2,7,11,15}->9
   */
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      var complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    System.out.println(map);
    return null;
  }

  /**
   * @param nums
   * @return Problem:217
   */
  public static boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
      if (map.get(i) > 1) {
        return true;
      }
    }
    return false;
  }

  /**
   * @param nums
   * @return Problem: 2419: Longest SubArray with Maximum Bitwise AND
   * Kaden's Algorithm
   */
  public static int longestSubarray(int[] nums) {
    int max = 0;
    int currentMax = Arrays.stream(nums).max().getAsInt();
    int size = 0;
    for (int i : nums) {
      if (i > currentMax) {
        currentMax = i;
        size = 1;
      } else if (i == currentMax) {
        size += 1;
      } else {
        size = 0;
      }
      max = Math.max(max, size);
    }
    return max;
  }

  /**
   * @param s
   * @return Problem : 1371: Longest Substring Containing vowels in even count
   */
  public static int findTheLongestSubstring(String s) {
    return 0;
  }

  /**
   * @param s
   * @param dictionary
   * @return Problem: 2707: Extra characters in a String
   */
  public static int minExtraChar(String s, String[] dictionary) {
    List<String> dic = Arrays.asList(dictionary);
    int j = 0, i = 1;
    while (i < s.length()) {
      if (dic.contains(s.substring(j, i))) {
        System.out.println(s.substring(j, i));
        s = s.replaceAll(s.substring(j, i), "");
      }
      j++;
    }
    return s.length();
  }

  /**
   * @param s
   * @return Problem: 151: Reverse Words in a string
   */
  public static String reverseWords(String s) {
    s = s.replaceAll(" *", "");
    String[] split = s.split(" ");
    int len = split.length - 1;
    for (int i = 0; i < len / 2; i++) {
      String temp = split[i];
      split[i] = split[len - i];
      split[len - i] = temp;
    }
    System.out.println(Arrays.toString(split));
    return Arrays.stream(split).filter(Objects::nonNull).collect(Collectors.joining(" "));
  }

  /**
   * @param s
   * @param k
   * @return Problem: 1456: maximum number of vowels in a substring of given length
   */
  public static int maxVowels(String s, int k) {
    List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
    int currentCount = 0, maxCount = 0, i = 0;
    for (; i < k; i++) {
      if (vowels.contains(s.charAt(i))) {
        currentCount += 1;
      }
    }
    maxCount = Math.max(currentCount, maxCount);
    for (; i < s.length(); i++) {
      if (vowels.contains(s.charAt(i))) {
        currentCount += 1;
      }
      if (vowels.contains(s.charAt(i - k))) {
        currentCount -= 1;
      }
      maxCount = Math.max(currentCount, maxCount);
    }
    return maxCount;
  }

  /**
   * @param arr
   * @return Problem: 1331: Rank Transform of an Array
   */
  public static int[] arrayRankTransform(int[] arr) {
    int[] copy = Arrays.copyOf(arr, arr.length);
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.sort(copy);
    for (int i : copy) {
      map.putIfAbsent(i, map.size() + 1);
    }
    System.out.println(Arrays.toString(copy));
    System.out.println(map);
    for (int i = 0; i < arr.length; i++) {
      arr[i] = map.get(arr[i]);
    }
    return arr;
  }

  /**
   * @param nums
   * @param p
   * @return Problem: 1590: Make sum divisible by p
   */
  public static int minSubarray(int[] nums, int p) {
    int totalSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      totalSum += i;
      map.put(i, totalSum);
    }
    if (totalSum % p == 0) {
      return 0;
    } else {
      int reminder = totalSum % p;
      map.remove(reminder);
    }
    return map.size();
  }

  /**
   * @param word1
   * @param word2
   * @return Problem: 1768: Merge Strings alternatively
   */
  public static String mergeAlternately(String word1, String word2) {
    int i = 0, j = 0;
    StringBuilder res = new StringBuilder();
    int lengthOfWord2 = word2.length();
    int lengthOfWord1 = word1.length();
    while (i < lengthOfWord1 && j < lengthOfWord2) {
      if (i == j) {
        res.append(word1.charAt(i));
        i++;
      } else {
        res.append(word2.charAt(j));
        j++;
      }
    }
    if (i < lengthOfWord1) {
      res.append(word1.substring(i));
    }
    if (j < lengthOfWord2) {
      res.append(word2.substring(j));
    }
    return res.toString();
  }

  /**
   * @param s
   * @return Problem: 345: Reverse Vowels of a String
   */
  public static String reverseVowels(String s) {
    StringBuilder lowerCase = new StringBuilder(s);
    int left = 0, right = lowerCase.length() - 1;
    int i = Integer.MIN_VALUE, j = Integer.MIN_VALUE;
    while (left < right) {
      if (lowerCase.charAt(left) == 'a' || lowerCase.charAt(left) == 'e' || lowerCase.charAt(left) == 'i'
              || lowerCase.charAt(left) == 'o' || lowerCase.charAt(left) == 'u' || lowerCase.charAt(left) == 'A' ||
              lowerCase.charAt(left) == 'E' || lowerCase.charAt(left) == 'I'
              || lowerCase.charAt(left) == 'O' || lowerCase.charAt(left) == 'U') {
        i = left;
      } else {
        left++;
      }
      if (lowerCase.charAt(right) == 'a' || lowerCase.charAt(right) == 'e' || lowerCase.charAt(right) == 'i'
              || lowerCase.charAt(right) == 'o' || lowerCase.charAt(right) == 'u' ||
              lowerCase.charAt(right) == 'A' || lowerCase.charAt(right) == 'E' || lowerCase.charAt(right) == 'I'
              || lowerCase.charAt(right) == 'O' || lowerCase.charAt(right) == 'U') {
        j = right;
      } else {
        right--;
      }
      if (i >= 0 && j > 0) {
        char temp = s.charAt(i);
        lowerCase.setCharAt(i, s.charAt(j));
        lowerCase.setCharAt(j, temp);
        i = Integer.MIN_VALUE;
        j = Integer.MIN_VALUE;
        left++;
        right--;
      }
    }
    return lowerCase.toString();
  }

  /**
   * @param nums
   * @param k
   * @return Problem: 2530 Maximal Scrore After Applying K operations
   */
  public static long maxKelements(int[] nums, int k) {
    long score = 0;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
    int i = 0;
    for (; i < nums.length; i++) {
      priorityQueue.offer(nums[i]);
    }
    while (k > 0) {
      System.out.println(priorityQueue.peek());
      Double popped = Double.valueOf(priorityQueue.poll());
      score += popped;
      priorityQueue.offer((int) Math.ceil(popped / 3));
      k--;
    }
    return score;
  }

  /**
   * @param s
   * @return Problem: 2938: Separate Black and White Balls
   * TODO to be done once you learn quick sort
   */
  public static long minimumSteps(String s) {
    int length = s.length();
    int left = 0;
    long res = 0;
    for (int right = 0; right < length; right++) {
      if (s.charAt(right) == '0') {
        res += (right - left);
        left++;
      }
    }
    return res;
  }

  /**
   * @param nums
   * @return Problem: 75: Sort Colors
   */
  public static int[] sortArrayQuickSort(int[] nums) {
    quickSortRecursively(nums, 0, nums.length - 1);
    return nums;
  }

  private static void quickSortRecursively(int[] nums, int low, int high) {
    if (low < high) {
      int pivot = getPivot(nums, low, high);
      quickSortRecursively(nums, low, pivot - 1);
      quickSortRecursively(nums, pivot + 1, high);
    }
  }

  private static int getPivot(int[] nums, int low, int high) {
    int i = low - 1;
    int pivot = nums[high];
    for (int j = low; j < high; j++) {
      if (nums[j] < pivot) {
        int temp = nums[j];
        nums[j] = nums[++i];
        nums[i] = temp;
      } else {

      }
    }
    int temp = nums[high];
    nums[high] = nums[++i];
    nums[i] = temp;
    return i;
  }

  /**
   * @param nums Problem: 283: Move Zeroes
   */
  public static void moveZeroes(int[] nums) {
    int zero = 0;
    for (int nonZero = 0; nonZero < nums.length; nonZero++) {
      if (nums[nonZero] != 0 && zero != nonZero) {
        nums[zero] ^= nums[nonZero];
        nums[nonZero] ^= nums[zero];
        nums[zero] ^= nums[nonZero];
        zero++;
      } else if (nums[zero] != 0) {
        zero++;
      }
    }
    System.out.println(Arrays.toString(nums));
  }

  /**
   * @param s
   * @param t
   * @return Problem: 392 IsSubSequence
   */
  public static boolean isSubsequence(String s, String t) {
    int right = 0, left = 0;
    if (!s.isEmpty() && !t.isEmpty()) {
      while (right < t.length() && left < s.length()) {
        if (t.charAt(right) == s.charAt(left)) {
          System.out.println("Found 1 match");
          left++;
        }
        right++;
        if (left == s.length()) {
          return true;
        }
      }
      return false;
    }
    return true;
  }

  /**
   * @param height
   * @return Problem:11 Container with most water
   */
  public static int maxArea(int[] height) {
    int maxArea = 0;
    int left = 0, right = height.length - 1;
    while (left < right) {
      int width = right - left;
      int area = width * Math.min(height[right], height[left]);
      maxArea = Math.max(maxArea, area);
      if (height[left] > height[right]) {
        right--;
      } else {
        left++;
      }
    }
    return maxArea;
  }

  /**
   * @param nums
   * @param k
   * @return Problem: 1679: Max number of K sum pairs
   */
  public static int maxOperations(int[] nums, int k) {
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num) && map.get(num) > 0) {
        count++;
        map.put(num, map.get(num) - 1);
      } else {
        map.put(k - num, map.getOrDefault(k - num, 0) + 1);
      }
    }
    return count;
  }

  /**
   * @param s
   * @return Problem: 2390: Removing Stars From a String
   */
  public static String removeStars(String s) {
    Stack<Character> stack = new Stack<>();
    for (char i : s.toCharArray()) {
      if (i != '*') {
        stack.push(i);
      } else {
        stack.pop();
      }
    }
    return stack.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).reverse().toString();
  }

  /**
   * @param s
   * @return Problem: 1957: Delete characters to make fancy String
   */
  public static String makeFancyString(String s) {
    int count = 0;
    char prev = 0;
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != prev) {
        count = 1;
        prev = s.charAt(i);
      } else {
        count++;
      }
      if (count < 3) {
        res.append(s.charAt(i));
      }
    }
    return res.toString();
  }

  /**
   * @param sentence
   * @return Problem 2490: Circular Sentence
   */
  public static boolean isCircularSentence(String sentence) {
    String[] words = sentence.split(" ");
    char prev = words[0].charAt(words[0].length() - 1);
    for (int right = 1; right < words.length; right++) {
      String currentWord = words[right];
      if (currentWord.charAt(0) != prev) {
        return false;
      }
      prev = currentWord.charAt(currentWord.length() - 1);
    }
    return words[0].charAt(0) == prev;
  }

  /**
   * @param s
   * @param goal
   * @return Problem: 796: Rotate String
   */
  public static boolean rotateString(String s, String goal) {
    if (s.length() != goal.length()) {
      return false;
    }
    return (s + s).contains(goal);
  }

  /**
   * @param nums
   * @param target
   * @return Problem: 209 - Minimum Size SubArray Sum
   */
  public static int minSubArrayLen(int target, int[] nums) {
    int res = Integer.MAX_VALUE;
    int left = 0, right = 0, sum = 0;
    while (right < nums.length) {
      sum += nums[right];
      while (sum >= target) {
        sum -= nums[left];
        res = Math.min(res, right - left);
        left++;
      }
      right++;
    }
    return res == Integer.MAX_VALUE ? 0 : res + 1;
  }

  /**
   * @param nums
   * @param k
   * @return Problem: 2461: Maximum sum of distinct subArrays with length K
   */
  public static long maximumSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> countMap = new HashMap<>();
    int i = 0;
    long maxSum = 0, currentSum = 0;
    for (; i < k; i++) {
      currentSum += nums[i];
      countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
    }
    if (countMap.size() == k) {
      maxSum = Math.max(maxSum, currentSum);
    }
    for (; i < nums.length; i++) {
      currentSum += nums[i] - nums[i - k];
      countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
      countMap.put(nums[i - k], countMap.getOrDefault(nums[i - k], 0) - 1);
      if (countMap.get(nums[i - k]) == 0) {
        countMap.remove(nums[i - k]);
      }
      if (countMap.size() == k) {
        maxSum = Math.max(maxSum, currentSum);
      }
    }
    return maxSum;
  }

}