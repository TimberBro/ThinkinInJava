package com.test.initialization;

public class Exercise16 {
    public static void main(String[] args){
        String[] a = {
                new String("First"),
                new String("Second"),
                "Third",
        };
        for(String x : a){
            System.out.println(x);
        }
    }
}
