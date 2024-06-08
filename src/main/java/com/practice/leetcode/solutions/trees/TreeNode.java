package com.practice.leetcode.solutions.trees;

public class TreeNode {
  public Integer data;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(Integer data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public TreeNode(Integer data) {
    this.data = data;
  }
}
