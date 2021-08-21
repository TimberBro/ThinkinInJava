package com.test.generics;

public class Sloop implements Ship {

  @Override
  public void dropAnchor() {
    System.out.println("Sloop dropped anchor");
  }

  @Override
  public void raiseAnchor() {
    System.out.println("Sloop raised anchor");
  }
}
