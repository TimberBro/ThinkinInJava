package com.test.control;

public class PrimeNumbers {
  static int isPrime(int limit) {
    for (int primeNominee = 2; primeNominee < limit; primeNominee++) {
      int trigger = 0;
      for (int i = 2; i <= primeNominee / 2; i++) {
        if (primeNominee % i == 0) {
          trigger = 1;
          break;
        }
      }
      if (trigger == 0) {
        System.out.println(primeNominee + " is a Prime Number!");
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int x = 100;
    PrimeNumbers.isPrime(x);
  }
}
