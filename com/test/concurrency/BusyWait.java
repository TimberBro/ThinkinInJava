package com.test.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class LightSwitch {

  boolean lighted = false;

  public synchronized void setLightedOn() {
    lighted = true; // Ready to buff
    notifyAll();
  }

  public synchronized void setLightedOff() {
    lighted = false; // Ready for another coat of wax
    notifyAll();
  }

  public synchronized void waitForTurningOn() throws InterruptedException {
    while (!lighted) {
      wait();
    }
  }

  public synchronized void waitForTurningOff() throws InterruptedException {
    while (lighted) {
      wait();
    }
  }
}

class TurnOn implements Runnable {

  private LightSwitch lightSwitch;

  public TurnOn(LightSwitch lightSwitch) {
    this.lightSwitch = lightSwitch;
  }

  @Override
  public void run() {
    try {
      while (!Thread.interrupted()) {
        System.out.println("Lights On!");
        TimeUnit.MILLISECONDS.sleep(200);
        lightSwitch.setLightedOn();
        lightSwitch.waitForTurningOff();
      }
    } catch (InterruptedException e) {
      System.out.println("Exiting via interrupt");
    }
    System.out.println("Ending TurnOn task");
  }
}

class TurnOff implements Runnable {

  private LightSwitch lightSwitch;

  public TurnOff(LightSwitch lightSwitch) {
    this.lightSwitch = lightSwitch;
  }

  @Override
  public void run() {
    try {
      while (!Thread.interrupted()) {
        lightSwitch.waitForTurningOn();
        System.out.println("Lights Off!");
        TimeUnit.MILLISECONDS.sleep(200);
        lightSwitch.setLightedOff();
      }
    } catch (InterruptedException e) {
      System.out.println("Exiting via interrupt");
    }
    System.out.println("Ending TurnOn task");
  }
}

// Fixed version, that uses wait(), instead of busy waits.
public class BusyWait {

  public static void main(String[] args) throws Exception {
    LightSwitch lightSwitch = new LightSwitch();
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new TurnOff(lightSwitch));
    exec.execute(new TurnOn(lightSwitch));
    TimeUnit.SECONDS.sleep(5);
    exec.shutdownNow();
  }
}
