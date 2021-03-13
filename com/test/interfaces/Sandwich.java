package com.test.interfaces;

interface FastFood {
  int getCalories();
  String getSauceType();
  String getDrinkName();
}

class Meal {
  Meal() {
    System.out.println("Meal()");
  }
}

class Bread {
  Bread() {
    System.out.println("Bread()");
  }
}

class Cheese {
  Cheese() {
    System.out.println("Cheese()");
  }
}

class Lettuce {
  Lettuce() {
    System.out.println("Lettuce()");
  }
}

class Pickle {
  Pickle() {
    System.out.println("Pickle()");
  }
}

class Lunch extends Meal {
  Lunch() {
    System.out.println("Lunch()");
  }
}

class PortableLunch extends Lunch {
  PortableLunch() {
    System.out.println("PortableLunch() ");
  }
}

public class Sandwich extends PortableLunch implements FastFood{
  private Bread b = new Bread();
  private Pickle p = new Pickle();
  private Cheese c = new Cheese();
  private Lettuce l = new Lettuce();
  public Sandwich() {
    System.out.println("Sandwich()");
  }

  public static void main(String[] args) {
    Sandwich sandwich = new Sandwich();
    System.out.println(sandwich.getCalories() + " calories");

    System.out.println(sandwich.getSauceType());
    System.out.println(sandwich.getDrinkName());
  }

  @Override
  public int getCalories() {
    return 1500;
  }

  @Override
  public String getSauceType() {
    return "Cheese sauce";
  }

  @Override
  public String getDrinkName() {
    return "Sprite";
  }
}
