package com.test.controlflow;

public class Fibonacci {
    public static void fibonacciCaltulate(int number){
        int[] answerarray = new int[number];
        answerarray[0] = 1;
        answerarray[1] = 1;
        for (int i = 2; i < answerarray.length; i++){
            answerarray[i] = answerarray[i-1] + answerarray[i-2];
        }
        for (int value : answerarray) {
            System.out.print(value + " ");
        }
    }
    public static void main(String[] args){
        Fibonacci.fibonacciCaltulate(Integer.parseInt(args[0]));
    }
}
