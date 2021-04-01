package com.test.innerclasses;

public class House {

  private String key = "Secret key";
  private String getKey() {
    return key;
  }

  void callSecurity() {
    Security security = new Security();
    security.changeKey("New secret key");
  }

  class Security {
    void changeKey(String s) {
      key = s;
    }
  }

  public static void main(String[] args) {
    House house = new House();
    System.out.println(house.getKey());
    house.callSecurity();
    System.out.println(house.getKey());
  }
}
