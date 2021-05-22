package com.test.holding.shape;

import java.util.Iterator;
import java.util.Random;

public class RandomShapeGenerator implements Iterable<Shape>{
    private final Random rand = new Random(47);
    private final int size;
    public Shape next(){
        switch (rand.nextInt(4)){
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
            case 3: return new Trapezoid();
        }
    }

    RandomShapeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Shape next() {
                ++index;
                return RandomShapeGenerator.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
