package com.test.holding.shape;

public class Trapezoid extends Shape {
    @Override
    public void move() {
        System.out.println("Move trapezoid");
    }

    @Override
    public void erase() {
        System.out.println("Trapezoid.erase()");
    }

    @Override
    public void draw() {
        System.out.println("Trapezoid.draw()");
    }
}
