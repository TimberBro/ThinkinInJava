package com.test.reusing;

public class Soap {
  // Add delegation to Soap class
  private Cleanser cleanser = new Cleanser();

  public String toString() {
    return cleanser.toString();
  }

  public void scrub() {
    cleanser.append(" Soap.scrub()");
  }

  public void sterillize() {
    cleanser.append(" sterillize()");
  }

  public void dilute() {
    cleanser.dilute();
  }

  public void apply() {
    cleanser.apply();
  }

  public void foam() {
    cleanser.append(" foam() ");
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

  void dispose() {
    System.out.println("Destroying cleanser.");
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
    x.dispose();
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

  void dispose() {
    System.out.println("Destroying detergent.");
    super.dispose();
  }

  // Test the new class:
  public static void main(String[] args) {
    Detergent x = new Detergent();
    x.dilute();
    x.apply();
    x.scrub();
    x.foam();
    System.out.println(x);
    x.dispose();
    System.out.println("Using base class:");
    Cleanser.main(args);
  }
}
