package com.practice.leetcode.solutions.graphs;

public class GraphSolutionsLeetCode {
  /**
   * @param n
   * @param edges
   * @param source
   * @param destination
   * @return Problem: 1971: Find if path exists in graph
   */
  public static boolean validPath(int n, int[][] edges, int source, int destination) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < edges[i].length; j++) {
        System.out.println(edges[i][j]);
        if (edges[source][destination] == edges[i][j]) {
          return true;
        }
      }
    }
    return false;
  }
}
