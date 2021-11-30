package com.test.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class LightSwitch {

  boolean lighted = false;
}

class TurnOn implements Runnable {

  private LightSwitch lightSwitch;

  public TurnOn(LightSwitch lightSwitch) {
    this.lightSwitch = lightSwitch;
  }

  @Override
  public void run() {
    try {
      TimeUnit.SECONDS.sleep(1);
      lightSwitch.lighted = true;
      System.out.println("Light turned on.");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class TurnOff implements Runnable {

  private LightSwitch lightSwitch;

  public TurnOff(LightSwitch lightSwitch) {
    this.lightSwitch = lightSwitch;
  }

  @Override
  public void run() {
    while (!lightSwitch.lighted) {
      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    lightSwitch.lighted = false;
    System.out.println("Light turned off.");
  }
}

// Busy wait approach. Slow because we should wait for timeouts.
public class BusyWait {

  public static void main(String[] args) {
    LightSwitch lightSwitch = new LightSwitch();
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new TurnOff(lightSwitch));
    exec.execute(new TurnOn(lightSwitch));
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    exec.shutdown();
  }
}
