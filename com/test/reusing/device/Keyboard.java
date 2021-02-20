package com.test.reusing.device;

public class Keyboard {

  private String status;

  protected void printStatus() {
    System.out.println(status);
  }

  public Keyboard() {
    System.out.println("Keyboard created");
    status = "New";
  }
}
