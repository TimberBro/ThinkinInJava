package com.test.generics;

interface Payable {}

class Employee implements Payable {}

class Hourly extends Employee implements Payable {}

public class MultipleInterfaceVariants {
  public static void main(String[] args) {
    new Employee();
    new Hourly();
  }
}
