package com.test.holding.shape;


public class Shapes {
    public static void main(String[] args) {
        RandomShapeGenerator generator = new RandomShapeGenerator(5);
        for (Shape shape : generator) {
            shape.move();
        }
    }
}
