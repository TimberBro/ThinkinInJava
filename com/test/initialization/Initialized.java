package com.test.initialization;

public class Initialized {
    String x;
    String y;
    Initialized(){
        y = "Hello world!";
    }
    public static void main(String[] args){
        Initialized test = new Initialized();
        System.out.println("x equal to " + test.x);
        System.out.println("y equal to " + test.y);
        test.x = "why?";
        System.out.println("x equal to " + test.x);
    }
}
