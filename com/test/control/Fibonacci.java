package com.test.control;

public class Fibonacci {
  public static void fibonacciCalculate(int number) {
    int[] answerArray = new int[number];
    answerArray[0] = 1;
    answerArray[1] = 1;
    for (int i = 2; i < answerArray.length; i++) {
      answerArray[i] = answerArray[i - 1] + answerArray[i - 2];
    }
    for (int value : answerArray) {
      System.out.print(value + " ");
    }
  }
  
  public static void main(String[] args) {
    Fibonacci.fibonacciCalculate(Integer.parseInt(args[0]));
  }
}
