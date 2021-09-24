package com.test.containers;

import java.util.PriorityQueue;
import java.util.Random;

public class Exercise11 implements Comparable<Exercise11> {
  static Random rand = new Random(47);
  int number;

  Exercise11() {
    number = rand.nextInt(100);
  }

  @Override
  public String toString() {
    return "Exercise11{" + "number=" + number + '}';
  }

  @Override
  public int compareTo(Exercise11 o) {
    if (number > o.number) {
      return 1;
    } else if (number < o.number) {
      return -1;
    }
    return 0;
  }

  public static void main(String[] args) {
    PriorityQueue<Exercise11> queue = new PriorityQueue<>();
    for (int i = 0; i < 10; i++) {
      queue.add(new Exercise11());
    }

    while (!queue.isEmpty()) {
      System.out.println(queue.poll());
    }
  }
}
