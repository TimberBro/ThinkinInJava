package com.test.initialization;

public class NonStaticStrings {
  String str;

  {
    str = "Non-static string";
    System.out.println("String was initialized");
  }

  public static void main(String[] args) {
    NonStaticStrings x = new NonStaticStrings();
    System.out.println(x.str);
  }
}
