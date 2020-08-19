package com.test.controlflow;

public class PrimeNumbers {
    static int isPrime(int limit) {
        for (int PrimeNominee = 2; PrimeNominee < limit; PrimeNominee++) {
            int trigger = 0;
            for (int i = 2; i <= PrimeNominee / 2; i++) {
                if (PrimeNominee % i == 0) {
                    trigger = 1;
                    break;
                }
            }
            if (trigger == 0) {
                System.out.println(PrimeNominee + " is a Prime Number!");
            }
        }
    return 0;
    }

    public static void main(String[] args){
        int x = 100;
        PrimeNumbers.isPrime(x);
    }
}
