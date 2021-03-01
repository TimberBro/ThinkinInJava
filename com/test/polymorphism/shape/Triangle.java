package com.test.polymorphism.shape;

public class Triangle extends Shape {
  @Override
  public void draw() {
    System.out.println("Triangle.draw()");
  }

  @Override
  public void move() {
    System.out.println("Move triangle");
  }

  @Override
  public void erase() {
    System.out.println("Triangle.erase()");
  }
}
