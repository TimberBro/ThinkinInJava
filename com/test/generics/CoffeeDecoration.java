package com.test.generics;

import java.util.Random;

class BasicCoffee {
  private String beanCountry;

  public void setBeanCountry(String country) {
    beanCountry = country;
  }

  public String getBeanCountry() {
    return beanCountry;
  }
}

class Decorator extends BasicCoffee {
  protected BasicCoffee basicCoffee;

  public Decorator(BasicCoffee basicCoffee) {
    this.basicCoffee = basicCoffee;
  }

  public void setCountry(String country) {
    basicCoffee.setBeanCountry(country);
  }

  public String getCountry() {
    return basicCoffee.getBeanCountry();
  }
}

class SteamedMilk extends Decorator {
  private final int milkTemperature = 65;

  public SteamedMilk(BasicCoffee basicCoffee) {
    super(basicCoffee);
  }

  public int getMilkTemperature() {
    return milkTemperature;
  }
}

class Foam extends Decorator {
  private Random random = new Random();
  private int foamHeight;

  public Foam(BasicCoffee basicCoffee) {
    super(basicCoffee);
    foamHeight = random.nextInt();
  }

  public int getFoamHeight() {
    return foamHeight;
  }
}

class Chocolate extends Decorator {
  private Random random = new Random();
  private int chocolatePortionSize;

  public Chocolate(BasicCoffee basicCoffee) {
    super(basicCoffee);
    chocolatePortionSize = random.nextInt();
  }

  public int getChocolatePortion() {
    return chocolatePortionSize;
  }
}

class Caramel extends Decorator {
  private Random random = new Random();
  private int caramelPortionSize;

  public Caramel(BasicCoffee basicCoffee) {
    super(basicCoffee);
    caramelPortionSize = random.nextInt();
  }

  public int getCaramelPortionSize() {
    return caramelPortionSize;
  }
}

class WhippedCream extends Decorator {
  private Random random = new Random();
  private int whippedCreamHeight;

  public WhippedCream(BasicCoffee basicCoffee) {
    super(basicCoffee);
    whippedCreamHeight = random.nextInt();
  }

  public int getWhippedCreamHeight() {
    return whippedCreamHeight;
  }
}

public class CoffeeDecoration {
  public static void main(String[] args) {
    Decorator latte = new Foam(new SteamedMilk(new BasicCoffee()));
    // Type of the object that results from using decorators is the last type that it was decorated
    // with.
    System.out.println(latte.getClass().getSimpleName());
    Decorator creamChocolateCoffee = new WhippedCream(new Chocolate(new BasicCoffee()));
    System.out.println(creamChocolateCoffee.getClass().getSimpleName());
  }
}
