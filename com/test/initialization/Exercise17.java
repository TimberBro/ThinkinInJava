package com.test.initialization;

public class Exercise17 {
    String y;
    Exercise17(String x){
        System.out.println("This is your argument :" + x);
        y = x;
    }
    public static void main(String[] args){
        System.out.println("In main");
        Exercise17[] X = {
                new Exercise17("b"),
                new Exercise17("c"),
                new Exercise17("a"),
                new Exercise17("d"),
        };
        for (Exercise17 s : X){
           System.out.println(s.y);
        }
    }
}
