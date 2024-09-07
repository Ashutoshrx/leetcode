package com.practice.leetcode.solutions.trees;

import java.util.List;

public class NArrayNode {
  public int val;
  public List<NArrayNode> children;

  public NArrayNode() {
  }

  public NArrayNode(int _val) {
    val = _val;
  }

  public NArrayNode(int _val, List<NArrayNode> _children) {
    val = _val;
    children = _children;
  }
}
