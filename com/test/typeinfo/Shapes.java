package com.test.typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
  void draw() {
    System.out.println(this + ".draw()");
  }

  void rotate(int degrees, boolean clockwise) {
    if (clockwise) {
      System.out.println(this + " was rotated " + degrees + " degrees clockwise");
    } else {
      System.out.println(this + " was rotated " + degrees + " degrees counterclockwise");
    }
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

public class Shapes {
  public static void main(String[] args) {
    List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
    for (Shape shape : shapeList) {
      shape.draw();
    }

    for (Shape shape : shapeList) {
      if (!(shape instanceof Circle)) {
        shape.rotate(15, true);
      }
    }
  }
}
