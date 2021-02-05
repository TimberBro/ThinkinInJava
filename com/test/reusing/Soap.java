package com.test.reusing;

public class Soap extends Detergent {
  public void scrub() {
    append(" Soap.scrub()");
  }

  public void sterillize() {
    append(" sterillize()");
  }

  public static void main(String[] args) {
    System.out.println("Using Soap class:");
    Soap x = new Soap();
    x.dilute();
    x.apply();
    x.scrub();
    x.foam();
    x.sterillize();
    System.out.println(x);
    System.out.println("Using Detergent class:");
    Detergent.main(args);
  }
}

class Cleanser {
  private String s = "Cleanser";

  public void append(String a) {
    s += a;
  }

  public void dilute() {
    append(" dilute() ");
  }

  public void apply() {
    append(" apply()");
  }

  public void scrub() {
    append(" scrub()");
  }

  public String toString() {
    return s;
  }

  public static void main(String[] args) {
    Cleanser x = new Cleanser();
    x.dilute();
    x.apply();
    x.scrub();
    System.out.println(x);
  }
}

class Detergent extends Cleanser {
  public void scrub() {
    append(" Detergent.scrub()");
    super.scrub(); // Call base-class version
  }

  // Add methods to the interface:
  public void foam() {
    append(" foam()");
  }

  // Test the new class:
  public static void main(String[] args) {
    Detergent x = new Detergent();
    x.dilute();
    x.apply();
    x.scrub();
    x.foam();
    System.out.println(x);
    System.out.println("Using base class:");
    Cleanser.main(args);
  }
}
