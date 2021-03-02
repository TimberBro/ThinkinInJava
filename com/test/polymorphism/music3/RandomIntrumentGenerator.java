package com.test.polymorphism.music3;

import java.util.Random;

public class RandomIntrumentGenerator {
    private final Random rand = new Random();
    public Instrument next(){
        switch (rand.nextInt(6)){
            default:
            case 0: return new Brass();
            case 1: return new Guitar();
            case 2: return new Wind();
            case 3: return new Woodwind();
            case 4: return new Percussion();
            case 5: return new Stringed();
        }
    }
}
