package com.practice.leetcode.solutions.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {
  public static void workAround() {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    pq.add(12);
    pq.add(4);
    pq.add(10);
    pq.add(1);
    System.out.println(pq.peek());
    pq.poll();
    System.out.println(pq.peek());
    System.out.println(pq);
  }

  //Print Kth Largest element present in an array
  public static int fetchKthLargestElement(int[] arr, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(k);
    int i = 0;
    for (; i < k; i++) {
      queue.offer(arr[i]);
    }
    for (; i < arr.length; i++) {
//      System.out.println(arr[i]);
//      System.out.println(queue.peek());
      if (queue.peek() < arr[i]) {
        queue.poll();
        queue.offer(arr[i]);
      }
    }
    return queue.peek();
  }
}
