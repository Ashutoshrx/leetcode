package com.practice.leetcode.solutions.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
  int vertices;
  int edges;
  int[][] graphUsingArray = new int[edges + 1][vertices + 1];
  List<List<Integer>> graphUsingList = new ArrayList<>();

  /**
   * Using matrix
   * Time Complexity- O(n**2)
   */
  public void addEdgesToArray(int dest, int source) {
    this.graphUsingArray[source][dest] = 1;
    this.graphUsingArray[dest][source] = 1;
  }

//  public static boolean dfs(int )
}
