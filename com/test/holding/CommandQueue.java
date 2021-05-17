package com.test.holding;

import java.util.LinkedList;
import java.util.Queue;

class Command {
  static private int counter;
  String command = "Command " + counter;

  public String operation() {
    return command;
  }

  Command() {
    counter++;
  }
}

class QueueFiller {
  static Queue<Command> fill(Queue<Command> queue) {
    for (int i = 0; i < 10 ; i++) {
      queue.add(new Command());
    }
    return queue;
  }
}

public class CommandQueue {
  static void queueOperation(Queue<Command> queue) {
    for (Command c : queue) {
      System.out.println(c.operation());
    }
  }

  public static void main(String[] args) {
    Queue<Command> commandQueue = new LinkedList<>();
    QueueFiller.fill(commandQueue);
    queueOperation(commandQueue);
  }
}
