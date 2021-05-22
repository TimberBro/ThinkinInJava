package com.test.holding;

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueuePrint {

  static void print(PriorityQueue<Double> queue) {
    while (!queue.isEmpty()) {
      System.out.println(queue.poll());
    }
  }

  public static void main(String[] args) {
    Random rand = new Random(47);
    PriorityQueue<Double> queue = new PriorityQueue<Double>();
    for (int i = 0; i < 10; i++) {
      queue.offer(rand.nextDouble());
    }
    print(queue);
  }
}
