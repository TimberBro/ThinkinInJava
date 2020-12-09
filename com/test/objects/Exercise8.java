package com.test.objects;

public class Exercise8 {
  public static String sharedString = "This string will be shared between objects";
  int constant = 42;

  public static void main(String[] args) {
    Exercise8 n = new Exercise8();
    System.out.println(n.sharedString);
    n.sharedString = "Changed string";
    Exercise8 e = new Exercise8();
    System.out.println(e.sharedString);
  }
}
