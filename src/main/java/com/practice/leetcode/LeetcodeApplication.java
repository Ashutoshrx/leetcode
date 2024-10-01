package com.practice.leetcode;

import com.practice.leetcode.solutions.stacks.CustomStack;

import java.beans.Customizer;
import java.util.Arrays;

import static com.practice.leetcode.solutions.InterviewPreparation.findMaxAverage;
import static com.practice.leetcode.solutions.InterviewPreparation.maxSlidingWindow;

public class LeetcodeApplication {

  String x = "Ashutosh";

  public static void main(String[] args) throws CloneNotSupportedException {
//		StringSolutions.lengthOfLastWord("Hello World");
//		StringSolutions.isPalindrome("Marge, let's \\\"[went].\\\" I await {news} telegram.");
//		StringSolutions.isValid("()[]{}");
//		StringSolutions.playWithArrays(79);
//    StringSolutions.longestSubString(Arrays.asList(25,75,31,72,99,28), 100);
//    StringSolutions.printSecondLargest(Arrays.asList(25,75,31,72,99,28));
//    StringSolutions.reverse("Ashutosh");
//    int i = StringSolutions.binarySearch(new int[]{12, 23, 45, 65, 76, 87, 104}, 104);
//    int[] i = StringSolutions.hello(new int[]{6, 5, 2, 8, 9, 4});
//    int[] i = StringSolutions.rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
//    System.out.println(i);
//    System.out.println(StringSolutions.searchInsertPosition(new int[]{1, 2, 4, 6, 7}, 3));
//    System.out.println(Arrays.toString(StringSolutions.plusOnePartTwo(new int[]{9,9})));
//    System.out.println(StringSolutions.isValidParenthesis("]"));
//    System.out.println(StringSolutions.isValidParenthesis("({{{{}}}))"));
//    System.out.println(StringSolutions.excelSheetColumnTitle(3));
    /*ListNode listNode =
            mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4, null))),
                    new ListNode(1, new ListNode(3, new ListNode(4, null))));*/
    /*ListNode listNode = deleteDuplicatesBetterApproach(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3,
            new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(4)))))))));*/
    /*ListNode listNode = addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9, null))),
            new ListNode(9, new ListNode(9, new ListNode(9, null))));*/
//    ListNode listNode = removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
//    listNode.show();
//    boolean b = StringSolutions.backspaceCompare("y#fo##f", "y#f#o##f");
//    System.out.println(b);


   /* LinkedList list = new LinkedList();
    list.insert("Ashu");
    list.insert("Tosh");
    list.insert("ToDeleteThis");
    list.insert("Pathy");

    list.insertAtStart("Ronnie");
    list.insertAt(3, "Sata");

    list.replaceAt(3, "Replaced");
    list.deleteAt(3);
    list.show();*/

    /*Stack myStack = new Stack();
    System.out.println("IsEmpty: " + myStack.isEmpty());
    myStack.pop();
    myStack.push("Ashu");
    myStack.push("Tosh");
    myStack.pop();
    myStack.push("Ronnie");
    myStack.push("The");
    System.out.println("IsEmpty: " + myStack.isEmpty());
    System.out.println("Size is: " + myStack.size());
    myStack.show();*/
    /*Queue queue = new Queue();
    System.out.println("IsEmpty:" + queue.isEmpty());
    queue.insert("Ashutosh");
    queue.insert("Satapathy");
    queue.insert("Ronnie");
    queue.delete();
    System.out.println("Peek:" + queue.peek());
    queue.show();
    System.out.println("IsEmpty:" + queue.isEmpty());*/

//    boolean b = checkValidString("(((((()*)(*)*))())())(()())())))((**)))))(()())()");
//    String b = minRemoveToMakeValid("))((");
//    String b = minRemoveToMakeValid("(((((");
//    String b = minRemoveToMakeValid("))((");
//    int b = countStudents(new int[]{1, 1}, new int[]{0, 1});
//    int b = countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1});
//    int b = timeRequiredToBuy(new int[]{4,1,3,2}, 2);
//    int b = timeRequiredToBuy(new int[]{2, 3, 2}, 2);
//    int[] b = deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});
//    String b = removeKDigits("1432219", 3);
//    String b = removeKDigits("10200", 1);
//    int b = trapWithNSpaceComplexity(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
//    int x = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});

   /* BinaryTree tree = new BinaryTree();
    tree.insert(1);
    tree.insert(2);
    tree.insert(3);
    tree.insert(4);
    tree.insert(null);
    tree.insert(null);
    tree.insert(5);
    tree.insert(8);
    tree.traverseInOrder();
    tree.getHeight();
    tree.levelOrderTraversal();*/
//    tree.showLevelsOfTree();
//      tree.viewRightOfBinaryTree();
    /*System.out.println();
    List<List<Integer>> lists = levelOrder(new TreeNode(1,
            new TreeNode(2, new TreeNode(4), null), new TreeNode(3,
            null, new TreeNode(5))));
    int num = findBottomLeftValue(new TreeNode(1,
            new TreeNode(2, new TreeNode(4), null), new TreeNode(3,
            null, new TreeNode(5))));
    System.out.println(lists);
    System.out.println(num);*/
//    List<Integer> integer1 = inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)));
//    int b = findSecondMaximum(new int[]{24, 54, 15, 76, 12});
    /*int b = findSecondMinimumValue(new TreeNode(29,
            new TreeNode(27, new TreeNode(12), new TreeNode(17)),
            new TreeNode(15, new TreeNode(5), new TreeNode(7))));*/
//    int b = maxDepth(new TreeNode(2, new TreeNode(2), new TreeNode(2147483647)));
//    int b = maxDepth(new TreeNode(1,new TreeNode(null),new TreeNode(3,new TreeNode(null),new TreeNode(4)));
//    System.out.println("Final:" + removeTrailingZeros("51230100"));
//    System.out.println("Final: " + findMaxK(new int[]{-10, 8, 6, 7, -2, -3}));
//    System.out.println(isAnagram("anagram","nagaram"));
//    removeDuplicatesAndStore(new ArrayList<>() {{
//      addAll(List.of(1, 2, 3, 5, 5, 6));
//    }});
//    System.out.println(firstRepeatingCharacter("Ashutosh")); ///FIXME interview question
//    System.out.println(scoreOfString("zaz"));
//    System.out.println(isMatch("aa","a*"));
//    TreeNode res = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
//    System.out.println(res);
//    addBinary("11", "1");
//    int res = singleNumber(new int[]{4, 1, 2, 1, 2});
//    int res = numWaterBottles(15, 4);
//    System.out.println(res);
   /* List<String> res = sortBasedOnStringSize(new ArrayList<>() {{
      add("Ashutosh");
      add("Satapathy");
      add("Ronnie");
    }});
//    System.out.println(res);
    Student student1 = new Student("Ashutosh", "Satapathy", new ListNode(3));
//    Student student2 = student1;
    Student student2 = (Student) student1.clone();
    student2.node = new ListNode(14);
    System.out.println(student1);
    System.out.println(student2);
    System.out.println(student1 == student2);
    System.out.println(student1.equals(student2));*/
//    int res = passThePillow(3,2);
//    System.out.println(res);
    /*Student student = new Student("Ash", "Sat");
    Immutable immutable = new Immutable("Ashutosh", "Satapathy", student);
    System.out.println(immutable);
    Student student1 = immutable.getStudent();
    student1.setFirstName("Ronnie");
    System.out.println(immutable);*/
//    int theWinner = findTheWinner(5, 2);
//    System.out.println(theWinner);
    /*String string = "Hello. How are you?";
    char str1[] = string.toCharArray();
    char str2[] = new char[21];
    int pos;

    for(pos=0; pos<18; pos++);
    {
      str2[pos] = str1[pos];
    }

    System.out.print(str1);
    System.out.print(str2);

  }*/
//    System.out.println(maximumGain("paaaabdbabfbybbbtaaab", 8132, 1776));
//    System.out.println(maximumGain("cdbcbbaaabab", 4, 5));
//    merge(new int[]{4, 0, 0, 0, 0, 0}, 1, new int[]{1, 2, 3, 5, 6}, 5);
//    merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
//    reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
//    boolean sameTree = isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2),
//            new TreeNode(3)));
//    System.out.println(sameTree);
//    TreeNode binaryTree = createBinaryTree(new int[][]{{20, 15, 1}, {0, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}});
//    System.out.println(binaryTree);
//            "This");
//    hasCycle(new ListNode(3,new ListNode(2)));
//    String[] res = sortPeople(new String[]{"Mary","John","Emma"}, new int[]{180,165,170});
//    frequencySort(new int[]{1, 1, 2, 2, 2, 3});
//    frequencySort(new int[]{2, 3, 1, 3, 2});
//    frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1});
//    int i = minimumDeletions("aababbab");
//    int i = minimumDeletions("bbaaaaabb");
//    boolean i = canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3});
//    int i = rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5);
//    String i = kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2);
//    int i= (30*6)+(98)+(29*6)+(27*6)+(31*6)+(29*6);
//    String i = numberToWords(12);
//    String i = numberToWords(950);
//    var i = construct2DArray(new int[]{1, 2, 3, 4},2,2);
//    var i = construct2DArray(new int[]{3},1,2);
//    var i = construct2DArray(new int[]{1,2},1,1);
//    boolean i = containsDuplicate(new int[]{1, 2, 3, 1});
//    String i = numberToWords(979);
//    var i = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
//    var i = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
//    var i = chalkReplacer(new int[]{3, 4, 1, 2}, 25);
//    var i = chalkReplacer(new int[]{5,1,5}, 22);
//    var i = validPath(3, new int[][]{{0, 1}, {2, 3}, {4, 5}}, 0, 2);
//    var i = validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2);
//    printNumberTriangular(6);
    /*var i = postorder(new NArrayNode(1,
            List.of(new NArrayNode(3, List.of(new NArrayNode(5), new NArrayNode(6))),
                    new NArrayNode(2),
                    new NArrayNode(4))));*/
//    int[] i = missingRolls(new int[]{1,2,3,4}, 6, 4);
//    var i = postorder(null);
//    var i = modifiedList(new int[]{1, 2}, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
//    i.show();
//    reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    /*var i = middleNode(new ListNode(1, new ListNode(2,
            new ListNode(3, new ListNode(4)))));*/
//    var i = swapPairs(new ListNode(1, new ListNode(2, new ListNode(3,
//            new ListNode(4)))));
//    i.show();
//    rotate(new int[]{-1, -100, 3, 99}, 2);
//    maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
//    rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
//    int[] ints = plusOnePartTwo(new int[]{1, 9, 9});
//    int i = longestSubarray(new int[]{1, 2, 3, 3, 2, 2});
//    ListNode i = insertGreatestCommonDivisors(new ListNode(18, new ListNode(6, new ListNode(10, new ListNode(3)))));
//    var i = uncommonFromSentences("this apple is sweet", "this apple is sour");
//    var i = shortestPalindrome("abcd");
    /*List<Double> i = averageOfLevels(new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5,
            new TreeNode(4), new TreeNode(6))));*/
//    int[] i = maxSlidingWindow(new int[]{8, 7, 6, 9}, 2);
//    int[] i = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
//    System.out.println(Arrays.toString(i));
    /*CustomStack customStack= new CustomStack(3);
    customStack.push(1);
    customStack.push(2);
    customStack.pop();
    customStack.push(2);
    customStack.push(3);
    customStack.push(4);
    customStack.increment(5,100);
    customStack.increment(2,100);
    customStack.pop();
    customStack.pop();
    customStack.pop();
    customStack.pop();*/
    double i = findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
//    double i = findMaxAverage(new int[]{-1}, 1);
//    double i = findMaxAverage(new int[]{1,2,3,4,5}, 2);
    System.out.println(i);
//    i.show();
  }
}
