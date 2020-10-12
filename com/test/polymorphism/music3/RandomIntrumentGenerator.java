package com.test.polymorphism.music3;
import com.test.polymorphism.shape.Circle;
import com.test.polymorphism.shape.Square;
import com.test.polymorphism.shape.Trapezoid;
import com.test.polymorphism.shape.Triangle;

import java.util.Random;

public class RandomIntrumentGenerator {
    private Random rand = new Random();
    public Instrument next(){
        switch (rand.nextInt(6)){
            default:
            case 0: return new Brass();
            case 1: return new Electro();
            case 2: return new Wind();
            case 3: return new Woodwind();
            case 4: return new Percussion();
            case 5: return new Stringed();
        }
    }
}
