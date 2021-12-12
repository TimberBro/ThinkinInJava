package com.test.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Meal {

  private final int orderNum;

  public Meal(int orderNum) {
    this.orderNum = orderNum;
  }

  public String toString() {
    return "Meal " + orderNum;
  }
}

class WaitPerson implements Runnable {

  Lock lock = new ReentrantLock();
  Condition condition = lock.newCondition();
  private Restaurant restaurant;

  public WaitPerson(Restaurant r) {
    restaurant = r;
  }

  public void run() {
    try {
      while (!Thread.interrupted()) {
        lock.lock();
        try {
          while (restaurant.meal == null) {
            condition.await(); // ... for the chef to produce a meal
          }
        } finally {
          lock.unlock();
        }
        System.out.println("Waitperson got " + restaurant.meal);
        restaurant.chef.lock.lock();
        try {
          restaurant.meal = null;
          restaurant.chef.condition.signalAll(); // Ready for another
        } finally {
          restaurant.chef.lock.unlock();
        }
      }
    } catch (InterruptedException e) {
      System.out.println("WaitPerson interrupted");
    }
  }
}

class Chef implements Runnable {

  Lock lock = new ReentrantLock();
  Condition condition = lock.newCondition();
  private Restaurant restaurant;
  private int count = 0;

  public Chef(Restaurant r) {
    restaurant = r;
  }

  public void run() {
    try {
      while (!Thread.interrupted()) {
        lock.lock();
        try {
          while (restaurant.meal != null) {
            condition.await(); // ... for the meal to be taken
          }
        } finally {
          lock.unlock();
        }
        if (++count == 10) {
          System.out.println("Out of food, closing");
          restaurant.exec.shutdownNow();
        }
        System.out.print("Order up! ");
        restaurant.waitPerson.lock.lock();
        try {
          restaurant.meal = new Meal(count);
          restaurant.waitPerson.condition.signalAll();
        } finally {
          restaurant.waitPerson.lock.unlock();
        }
        TimeUnit.MILLISECONDS.sleep(100);
      }
    } catch (InterruptedException e) {
      System.out.println("Chef interrupted");
    }
  }
}

public class Restaurant {

  Meal meal;
  ExecutorService exec = Executors.newCachedThreadPool();
  WaitPerson waitPerson = new WaitPerson(this);
  Chef chef = new Chef(this);

  public Restaurant() {
    exec.execute(chef);
    exec.execute(waitPerson);
  }

  public static void main(String[] args) {
    new Restaurant();
  }
}
