package com.test.innerclasses;

public class Housev2 {

  private String key = "Secret key";

  private String getKey() {
    return key;
  }

  void callSecurity() {
    new Object() {
      void changeKey() {
        key = "New secret key";
      }
    }.changeKey();
  }

  public static void main(String[] args) {
    Housev2 house = new Housev2();
    System.out.println(house.getKey());
    house.callSecurity();
    System.out.println(house.getKey());
  }
}
