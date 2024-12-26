package com.practice.leetcode.solutions;

import com.practice.leetcode.solutions.trees.NArrayNode;
import com.practice.leetcode.solutions.trees.TreeNode;

import java.util.*;

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
    TreeNode root = new TreeNode(0);
    for (int i : nums) {
      root = insertToBST(root, i);
    }
    return root;
  }

  private static TreeNode insertToBST(TreeNode root, int data) {
    if (root == null) {
      root = new TreeNode(data);
    } else {
      if (data < root.data) {
        root.left = insertToBST(root.left, data);
      } else {
        root.right = insertToBST(root.right, data);
      }
    }
    return root;
  }


  /**
   * @param p
   * @param q
   * @return Problem:100: Same Tree
   */
  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p != null && q != null) {
      if (Objects.equals(p.data, q.data)) {
        return isSameTree(p.left, q.left) &&
                isSameTree(q.right, q.right);
      } else {
        return false;
      }
    }
    return true;
  }

  /**
   * @param root
   * @return Problem:590 N- ary Tree Postorder Traversal
   */

  public static List<Integer> postorder(NArrayNode root) {
    List<Integer> res = new ArrayList<>();
    if (root != null) {
      Stack<NArrayNode> stack = new Stack<>();
      stack.push(root);
      while (!stack.isEmpty()) {
        NArrayNode curr = stack.pop();
        if (curr.children != null) {
          for (NArrayNode node : curr.children) {
            stack.push(node);
          }
        }
        System.out.println(curr.val);
        res.add(curr.val);
      }
      Collections.reverse(res);
    }
    return res;
  }

  /*public static List<Integer> preorder(NArrayNode root) {

  }

  public static List<Integer> inorder(NArrayNode root) {

  }*/

  /**
   * @param root
   * @return Problem: 637: Average of Levels in Binary Tree
   */
  public static List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) {
      res.add(Double.valueOf(root.data));
    }
    queue.offer(root);
    while (!queue.isEmpty()) {
      double count = 0, sum = 0;
      int length = queue.size();
      for (int i = 0; i < length; i++) {
        TreeNode current = queue.poll();
        if (current.left != null) {
          count++;
          sum += current.left.data;
          queue.offer(current.left);
        }
        if (current.right != null) {
          count++;
          sum += current.right.data;
          queue.offer(current.right);
        }
      }
      System.out.println(sum / count);
      if (count > 0) {
        res.add(sum / count);
      }
    }
    return res;
  }

  /**
   * @param root
   * @return Problem: 515: Find the largest value in each tree row
   */
  public static List<Integer> largestValues(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    int max = Integer.MIN_VALUE;
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.poll();
        if (current.right != null) {
          queue.offer(current.right);
        }
        if (current.left != null) {
          queue.offer(current.left);
        }
        max = Math.max(max, current.data);
      }
      res.add(max);
      max = Integer.MIN_VALUE;
    }
    return res;
  }

  /**
   * @param root
   * @param val
   * @return search BST
   */
  public static TreeNode searchBST(TreeNode root, int val) {
    if (root != null) {
      if (root.data == val) {
        return root;
      } else if (val > root.data) {
        return searchBST(root.right, val);
      } else {
        return searchBST(root.left, val);
      }
    } else {
      return null;
    }
  }

  /**
   * @param root
   * @param key
   * @return Problem: 450: Delete node in BST
   */
  public static TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (key < root.data) {
      root.left = deleteNode(root.left, key);
    } else if (key > root.data) {
      root.right = deleteNode(root.right, key);
    } else {
      if (root.right == null) {
        return root.left;
      } else if (root.left == null) {
        return root.right;
      } else {
        /* Using Minimum Value
        TreeNode curr = root.right;
        while (curr.left != null) {
          curr = curr.left;
        }
        root.data = curr.data;
        root.right = deleteNode(root.right, curr.data);*/
        //Using Maximum value
        TreeNode curr = root.left;
        while (curr.right != null) {
          curr = curr.right;
        }
        root.data = curr.data;
        root.left = deleteNode(root.left, root.data);
      }
    }
    return root;
  }
}