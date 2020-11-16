package com.test.objects;

public class Autoboxing {
  Boolean b = true;
  Character c = 'a';
  Byte be = 22;
  Short st = 287;
  Integer itg = 2147;
  Long lg = 922337203685477580l;
  Float ft = 43.2f;
  Double db = 42.3;

  public static void main(String[] args) {
    Autoboxing autoboxing = new Autoboxing();
    System.out.println(autoboxing.b);
    System.out.println(autoboxing.c);
    System.out.println(autoboxing.be);
    System.out.println(autoboxing.st);
    System.out.println(autoboxing.itg);
    System.out.println(autoboxing.lg);
    System.out.println(autoboxing.ft);
    System.out.println(autoboxing.db);
  }
}
