package com.practice.leetcode.solutions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
  TreeNode root;

  /* FIRST TIME LEARNING EXAMPLE-- EXERCISE -2

  public void insert(Integer data) {
    if (root == null) {
      root = new TreeNode(data);
      return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      if (current.left == null) {
        current.left = new TreeNode(data);
        return; // Inserted, so return
      } else {
        queue.offer(current.left);
      }
      if (current.right == null) {
        current.right = new TreeNode(data);
        return; // Inserted, so return
      } else {
        queue.offer(current.right);
      }
    }
  }

  public void insertToBST(int data) {
    root = insertRecordTOBST(root, data);
  }

  private TreeNode insertRecordTOBST(TreeNode root, int data) {
    if (root == null)
      root = new TreeNode(data);
    else if (data < root.data)
      root.left = insertRecordTOBST(root.left, data);
    else
      root.right = insertRecordTOBST(root.right, data);
    return root;
  }

  public void traverseInOrder() {
    System.out.println("\nTraversed In Order:");
    traverseRecordInOrder(root);
    System.out.println("\nTraversed Post Order:");
    traverseRecordPostOrder(root);
    System.out.println("\nTraversed Pre Order:");
    traverseRecordPreOrder(root);
  }

  private void traverseRecordInOrder(TreeNode root) {
    if (root != null) {
      traverseRecordInOrder(root.left);
      System.out.print(root.data + ",");
      traverseRecordInOrder(root.right);
    }
  }

  private void traverseRecordPostOrder(TreeNode root) {
    if (root != null) {
      traverseRecordInOrder(root.left);
      traverseRecordInOrder(root.right);
      System.out.print(root.data + ",");
    }
  }

  private void traverseRecordPreOrder(TreeNode root) {
    if (root != null) {
      System.out.print(root.data + ",");
      traverseRecordInOrder(root.left);
      traverseRecordInOrder(root.right);
    }
  }

  public void getHeight() {
    System.out.println("Height is:" + getHeightRec(root));
  }

  private int getHeightRec(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return Math.max(getHeightRec(root.left), getHeightRec(root.right)) + 1;
    }
  }

  public void levelOrderTraversal() {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      System.out.println(current.data);
      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }
  }

  public void viewLeftOfBinaryTree() {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll(); // poll-retrieves and removes the head
      System.out.println(current.data);
      if (current.left != null) {
        queue.add(current.left);
      }
    }
  }

  public void viewRightOfBinaryTree() {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll(); // poll-retrieves and removes the head
      System.out.println(current.data);
      if (current.right != null) {
        queue.add(current.right);
      }
    }
  }

  public void showLevelsOfTree() {
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    if (root != null) {
      nodeQueue.add(root);
      nodeQueue.add(null);
      while (!nodeQueue.isEmpty()) {
        TreeNode current = nodeQueue.poll(); // poll-retrieves and removes the head
        if (current == null) {
          if (nodeQueue.isEmpty()) {
            return;
          }
          nodeQueue.add(null);
          System.out.println();
          continue;
        }
        if (current.data != null) {
          System.out.print(current.data + ",");
        }
        if (current.left != null) {
          nodeQueue.add(current.left);
        }
        if (current.right != null) {
          nodeQueue.add(current.right);
        }
      }
    }
  }*/

  /* SECOND TIME LEARNING EXAMPLE-- EXERCISE -2*/
  public void insert(Integer data) {
    if (root == null) {
      root = new TreeNode(data);
    } else {
      Queue<TreeNode> treeNodeQueue = new LinkedList<>();
      treeNodeQueue.offer(root);
      while (!treeNodeQueue.isEmpty()) {
        TreeNode current = treeNodeQueue.poll();
        if (current.left == null) {
          current.left = new TreeNode(data);
          return;
        } else {
          treeNodeQueue.offer(current.left);
        }
        if (current.right == null) {
          current.right = new TreeNode(data);
          return;
        } else {
          treeNodeQueue.offer(current.right);
        }
      }
    }
  }

  public void traverseInOrder() {
    System.out.println("\n-----IN ORDER-----");
    traverseInOrderRec(root);
    System.out.println("\n-----PRE ORDER-----");
    traversePreOrderRec(root);
    System.out.println("\n-----POST ORDER-----");
    traversePostOrderRec(root);
  }

  private void traversePostOrderRec(TreeNode root) {
    if (root != null) {
      traverseInOrderRec(root.left);
      traverseInOrderRec(root.right);
      System.out.print(root.data + ", ");
    }
  }

  private void traversePreOrderRec(TreeNode root) {
    if (root != null) {
      System.out.print(root.data + ", ");
      traverseInOrderRec(root.left);
      traverseInOrderRec(root.right);
    }

  }

  private void traverseInOrderRec(TreeNode root) {
    if (root != null) {
      traverseInOrderRec(root.left);
      System.out.print(root.data + ", ");
      traverseInOrderRec(root.right);
    }
  }

  public void getHeight() {
    int count = 0;
    int height = getHeightRec(root, count);
    System.out.println("\nHeight is:" + height);
  }

  private int getHeightRec(TreeNode root, int count) {
    if (root != null) {
      count = Math.max(getHeightRec(root.left, count + 1), getHeightRec(root.right, count + 1));
    }
    return count;
  }

  public void levelOrderTraversal() {
    System.out.println("\n LEVEL ORDER TRAVERSAL");
    if (root != null) {
      Queue<TreeNode> treeNodeQueue = new LinkedList<>();
      treeNodeQueue.offer(root);
      while (!treeNodeQueue.isEmpty()) {
        TreeNode current = treeNodeQueue.poll();
        System.out.print(current.data + ", ");
        if (current.left != null) {
          treeNodeQueue.offer(current.left);
        }
        if (current.right != null) {
          treeNodeQueue.offer(current.right);
        }
      }
    }
  }


}
