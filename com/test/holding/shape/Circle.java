package com.test.holding.shape;

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }
    @Override
    public void move() {
        System.out.println("Move circle");
    }
    @Override
    public void erase() {
        System.out.println("Circle.erase()");
    }
}
