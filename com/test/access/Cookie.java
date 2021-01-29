package com.test.access;

public class Cookie {
  public int width = 1;
  protected int thick = 2;
  private int weight = 3;

  public void pub() {
    System.out.println("This is public method");
  }

  protected void prot() {
    System.out.println("This is protected method");
  }

  private void priv() {
    System.out.println("This is private method");
  }
}
