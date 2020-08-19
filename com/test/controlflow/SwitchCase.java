package com.test.controlflow;

public class SwitchCase {
    public static void main(String[] args){
        String Line = "abcdef";
        for (int i = 0 ; i < Line.length(); i++) {
            char symbol = Line.charAt(i);
            switch (symbol) {
                case 'a':
                    System.out.println("Symbol is " + symbol);
                    //break;
                case 'b':
                    System.out.println("Symbol is " + symbol);
                    //break;
                case 'c':
                    System.out.println("Symbol is " + symbol);
                    //break;
                case 'd':
                    System.out.println("Symbol is " + symbol);
                    //break;
                case 'e':
                    System.out.println("Symbol is " + symbol);
                    //break;
                case 'f':
                    System.out.println("Symbol is " + symbol);
                    //break;
            }
        }
    }
}
