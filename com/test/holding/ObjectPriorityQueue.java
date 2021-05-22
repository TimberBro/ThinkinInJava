package com.test.holding;

import java.util.PriorityQueue;

class SimpleClass extends Object {}

public class ObjectPriorityQueue {
  public static void main(String[] args) {
    PriorityQueue<SimpleClass> queue = new PriorityQueue();
    // Running this code will get
    // java.lang.ClassCastException: com.test.holding.SimpleClass cannot be cast to
    // java.lang.Comparable
    queue.offer(new SimpleClass());
    queue.offer(new SimpleClass());
  }
}
