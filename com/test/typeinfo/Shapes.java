package com.test.typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
  boolean highlighted = false;

  void draw() {
    System.out.println(this + ".draw(); Highlighted: " + highlighted);
  }

  void setHighlight() {
    highlighted = true;
  }

  void clearHighlight() {
    highlighted = false;
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
  static void highlightCircle(Shape shape) {
    if (shape instanceof Circle) {
      shape.setHighlight();
    }
  }

  public static void main(String[] args) {
    List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
    for (Shape shape : shapeList) {
      highlightCircle(shape);
      shape.draw();
    }
  }
}
