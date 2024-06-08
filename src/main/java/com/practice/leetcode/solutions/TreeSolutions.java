package com.practice.leetcode.solutions;

import com.practice.leetcode.solutions.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSolutions {
  /**
   * @param root
   * @return Problem: 404: Sum Of Left leaves of a binary Tree
   * @Input [3, 9, 20, null, null, 15, 7]
   * @Solution 24(9 + 15)
   */
  static int leftLeafSum = 0;
  static long min = Long.MAX_VALUE, secondMin = Long.MAX_VALUE;

  public static int sumOfLeftLeaves(TreeNode root) {
    root = traverse(root);
    return root.data;
  }

  private static TreeNode traverse(TreeNode root) {
    if (root != null) {
      System.out.print(root.data + ",");
      root.left = traverse(root.left);
      System.out.print("Left Data:" + root.left.data + ",");
      root.right = traverse(root.right);
    }
    return root;
  }

  /**
   * @param root
   * @return Problem:94: Binary Tree Inorder Traversal
   */
  public static List<Integer> inorderTraversal(TreeNode root) {
    return traverseInOrder(root, new ArrayList<>());
  }

  private static List<Integer> traverseInOrder(TreeNode root, List<Integer> res) {
    if (root != null) {
      traverseInOrder(root.left, res);
      res.add(root.data);
      System.out.print(root.data + ", ");
      traverseInOrder(root.right, res);
    }
    return res;
  }

  /**
   * @param root
   * @return Problem:671 - Second Minimum Node in a binary Tree
   */
  public static int findSecondMinimumValue(TreeNode root) {
    System.out.println(secondMin);
    findSecondMinimumValueRecursively(root);
    if (secondMin == Long.MAX_VALUE) {
      return -1;
    } else {
      return (int) secondMin;
    }
  }

  private static void findSecondMinimumValueRecursively(TreeNode root) {
    if (root != null) {
      System.out.println(root.data);
      if (root.data < min) {
        secondMin = min;
        min = root.data;
      } else if (root.data < secondMin && root.data != min) {
        secondMin = root.data;
      }
      findSecondMinimumValueRecursively(root.left);
      findSecondMinimumValueRecursively(root.right);
    }
  }

  /**
   * @param root
   * @return Problem :110 Balanced Binary Tree
   */
  public static boolean isBalanced(TreeNode root) {
    if (root != null) {
      return getDepth(root.left) - getDepth(root.right) == 1 || getDepth(root.left) - getDepth(root.right) == -1;
    }
    return true;
  }

  private static int getDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(getDepth(root.left), getDepth(root.right));
  }

  /**
   * @param root
   * @return Problem:129 Sum Root of Leaf Numbers
   */
  public static int sumNumbers(TreeNode root) {
    findSumNumbersRecursively(root);
    return 0;
  }

  private static void findSumNumbersRecursively(TreeNode root) {
    if (root != null) {
      if (isLeafNode(root)) {
        System.out.println(root.data);
      }
      findSumNumbersRecursively(root.left);
      findSumNumbersRecursively(root.right);
    }
  }

  private static boolean isLeafNode(TreeNode root) {
    return root.left == null && root.right == null;
  }

  public static int maxDepth(TreeNode root) {
    int sum = 0;
    sum += maxDepthRecursively(root);
    return sum;
  }

  private static int maxDepthRecursively(TreeNode root) {
    if (root != null) {
      return Math.max(maxDepthRecursively(root.left), maxDepthRecursively(root.right)) + 1;
    }
    return 0;
  }

  /**
   * @param root
   * @return Problem No:102- Binary Tree Level Order Traversal
   */
  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> response = new ArrayList<>();
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    if (root != null) {
      nodeQueue.add(root);
      while (!nodeQueue.isEmpty()) {
        int qLength = nodeQueue.size();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < qLength; i++) {
          TreeNode current = nodeQueue.poll();
          if (current != null) {
            temp.add(current.data);
            if (current.left != null) {
              nodeQueue.add(current.left);
            }
            if (current.right != null) {
              nodeQueue.add(current.right);
            }
          }
        }
        response.add(temp);
      }
    }
    return response;
  }

  /**
   * @param root
   * @return Problem:513: Find bottom left tree
   */
  public static int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    TreeNode current = null;
    while (!queue.isEmpty()) {
      current = queue.poll();
      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }
    return current.data;
  }

  /**
   * @param nums
   * @return Problem 108: Convert Sorted Array to Binary Search Tree
   */
  public static TreeNode sortedArrayToBST(int[] nums) {
    TreeNode root = null;
    for (int i : nums) {
      insertToBST(root, i);
    }
    return root;
  }

  private static void insertToBST(TreeNode root, int data) {
    if (root == null) {
      new TreeNode(data);
    } else {
      if (root.left == null) {
        root.left = new TreeNode(data);
      } else {
        root.right = new TreeNode(data);
      }
    }
  }

}