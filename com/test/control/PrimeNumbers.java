package com.test.control;

public class PrimeNumbers {
  static void printPrimeNumbers(int limit) {
    nextNumber:
    for (int primeNominee = 1; primeNominee <= limit; primeNominee++) {
      if (primeNominee == 1) {
        continue;
        } else {
        for (int i = 2; i <= primeNominee / 2; i++) {
          if (primeNominee % i == 0) {
            continue nextNumber;
          }
        }
      }
      System.out.println(primeNominee + " is a Prime Number!");
    }
  }

  public static void main(String[] args) {
    int x = 100;
    PrimeNumbers.printPrimeNumbers(x);
  }
}
