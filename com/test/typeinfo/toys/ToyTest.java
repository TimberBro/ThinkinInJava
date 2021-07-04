package com.test.typeinfo.toys;

import java.lang.reflect.Constructor;

interface HasBatteries {}

interface Waterproof {}

interface Shoots {}

interface Wireless {}

class Toy {
  int strength;

  public Toy(int i) {
    this.strength = i;
    System.out.println("Toy was created!");
  }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, Wireless {

  public FancyToy(int i) {
    super(i);
    System.out.println("FancyToy was created. Strength = " + i);
  }
}

public class ToyTest {
  static void printInfo(Class cc) {
    System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
    System.out.println("Simple name: " + cc.getSimpleName());
    System.out.println("Canonical name : " + cc.getCanonicalName());
  }

  static Toy getToy(String className, int strength) throws ClassNotFoundException {
    Class c = Class.forName(className);
    Constructor[] constructors = c.getConstructors();
    for (Constructor cnstr : constructors) {
      Class[] parameters = cnstr.getParameterTypes();
      if (parameters.length == 1) {
        if (parameters[0] == int.class) {
          try {
            return (Toy) cnstr.newInstance(strength);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    try {
      getToy("com.test.typeinfo.toys.FancyToy", 25);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
