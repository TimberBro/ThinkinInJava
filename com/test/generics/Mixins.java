package com.test.generics;

import java.util.Date;
import java.util.Random;

interface TimeStamped {
  long getStamp();
}

class TimeStampedImp implements TimeStamped {
  private final long timeStamp;

  public TimeStampedImp() {
    timeStamp = new Date().getTime();
  }

  public long getStamp() {
    return timeStamp;
  }
}

interface SerialNumbered {
  long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
  private static long counter = 1;
  private final long serialNumber = counter++;

  public long getSerialNumber() {
    return serialNumber;
  }
}

interface Basic {
  public void set(String val);

  public String get();
}

class BasicImp implements Basic {
  private String value;

  public void set(String val) {
    value = val;
  }

  public String get() {
    return value;
  }
}

interface Colored {

  public String getColor();
}

class ColoredImpl implements Colored {
  private final Random rand = new Random(47);
  private static final int MAX_RGB_VALUE = (int) Long.parseLong("FFFFFF", 16);
  private String color = Integer.toHexString(rand.nextInt(MAX_RGB_VALUE));

  @Override
  public String getColor() {
    return color;
  }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered, Colored {
  private TimeStamped timeStamp = new TimeStampedImp();
  private SerialNumbered serialNumber = new SerialNumberedImp();
  private Colored color = new ColoredImpl();

  public long getStamp() {
    return timeStamp.getStamp();
  }

  public long getSerialNumber() {
    return serialNumber.getSerialNumber();
  }

  public String getColor() {
    return color.getColor();
  }
}

public class Mixins {
  public static void main(String[] args) {
    Mixin mixin1 = new Mixin();
    Mixin mixin2 = new Mixin();
    mixin1.set("test string 1");
    mixin2.set("test string 2");
    System.out.println(
        mixin1.get()
            + " "
            + mixin1.getStamp()
            + " "
            + mixin1.getSerialNumber()
            + " "
            + mixin1.getColor());
    System.out.println(
        mixin2.get()
            + " "
            + mixin2.getStamp()
            + " "
            + mixin2.getSerialNumber()
            + " "
            + mixin1.getColor());
  }
}
