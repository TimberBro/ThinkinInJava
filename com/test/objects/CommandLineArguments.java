package com.test.objects;

public class CommandLineArguments {
  public static void main(String[] args) {
    if (args.length < 3) {
      System.out.println("Program requires at least 3 arguments.");
    } else {
      for (int i = 0; i < 3; i++) {
        System.out.println(args[i]);
      }
    }
  }
}
