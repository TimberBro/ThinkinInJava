package com.test.initialization;

public class Dog {
  public static void bark(char a) {
    System.out.println("Woof-woof: char");
  }

  public static void bark(byte a) {
    System.out.println("Woef-woef: byte");
  }

  public static void bark(short a) {
    System.out.println("Ham-ham: short");
  }

  public static void bark(int a) {
    System.out.println("Haf-haf: int");
  }

  public static void bark(long a) {
    System.out.println("Hum-hum: long");
  }

  public static void bark(float a) {
    System.out.println("Meong-meong: float");
  }

  public static void bark(double a) {
    System.out.println("Guau-guau: double");
  }

  public static void main(String[] args) {
    char c = Character.MAX_VALUE;
    bark(c);
    byte b = Byte.MAX_VALUE;
    bark(b);
    short sh = Short.MAX_VALUE;
    bark(sh);
    int i = Integer.MAX_VALUE;
    bark(i);
    long lg = Long.MAX_VALUE;
    bark(lg);
    float ft = Float.MAX_VALUE;
    bark(ft);
    double dbl = Double.MAX_VALUE;
    bark(dbl);
  }
}
