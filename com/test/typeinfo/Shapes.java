package com.test.typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
  void draw() {
    System.out.println(this + ".draw()");
  }

  public abstract String toString();
}

class Circle extends Shape {
  public String toString() {
    return "Circle";
  }
}

class Square extends Shape {
  public String toString() {
    return "Square";
  }
}

class Triangle extends Shape {
  public String toString() {
    return "Triangle";
  }
}

class Rhomboid extends Shape {

  @Override
  public String toString() {
    return "Rhomboid";
  }
}

public class Shapes {
  public static void main(String[] args) {
    List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
    for (Shape shape : shapeList) {
      shape.draw();
    }
    // Upcast to shape
    Shape shape = new Rhomboid();
    shape.draw();
    // Downcast back to Rhomboid
    Rhomboid rhomboid = (Rhomboid) shape;
    rhomboid.draw();
    // Downcast back to Circle. Will be successfully compiled, but will give
    // java.lang.ClassCastException
    Circle circle = (Circle) shape;
    circle.draw();
  }
}
