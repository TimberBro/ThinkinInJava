package com.test.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Item {

  private final int orderNum;

  public Item(int orderNum) {
    this.orderNum = orderNum;
  }

  public String toString() {
    return "Meal " + orderNum;
  }
}

class Consumer implements Runnable {

  private Restaurant restaurant;

  public Consumer(Restaurant r) {
    restaurant = r;
  }

  public void run() {
    try {
      while (!Thread.interrupted()) {
        synchronized (this) {
          while (restaurant.item == null) {
            wait(); // ... for the Producer to produce a meal
          }
        }
        System.out.println("Consumer got " + restaurant.item);
        synchronized (restaurant.producer) {
          restaurant.item = null;
          restaurant.producer.notifyAll(); // Ready for another
        }
      }
    } catch (InterruptedException e) {
      System.out.println("Consumer interrupted");
    }
  }
}

class Producer implements Runnable {

  private Restaurant restaurant;
  private int count = 0;

  public Producer(Restaurant r) {
    restaurant = r;
  }

  public void run() {
    try {
      while (!Thread.interrupted()) {
        synchronized (this) {
          while (restaurant.item != null) {
            wait(); // ... for the meal to be taken
          }
        }
        if (++count == 10) {
          System.out.println("Out of items, closing");
          restaurant.exec.shutdownNow();
        }
        System.out.print("Order up! ");
        synchronized (restaurant.consumer) {
          restaurant.item = new Item(count);
          restaurant.consumer.notifyAll();
        }
        TimeUnit.MILLISECONDS.sleep(100);
      }
    } catch (InterruptedException e) {
      System.out.println("Producer interrupted");
    }
  }
}

public class Restaurant {

  Item item;
  ExecutorService exec = Executors.newCachedThreadPool();
  Consumer consumer = new Consumer(this);
  Producer producer = new Producer(this);

  public Restaurant() {
    exec.execute(producer);
    exec.execute(consumer);
  }

  public static void main(String[] args) {
    new Restaurant();
  }
}
