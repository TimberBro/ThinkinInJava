package com.test.initialization;



public class Dog {
    public static void bark(char a, byte b){
        System.out.println("Da-da char");
    }
    public static void bark(byte a, char b){
        System.out.println("Da-da byte");
    }
    public static void bark(short a){
        System.out.println("Da-da short");
    }
    public static void bark(int a){
        System.out.println("Da-da int");
    }public static void bark(long a){
        System.out.println("Da-da long");
    }public static void bark(float a){
        System.out.println("Da-da float");
    }public static void bark(double a){
        System.out.println("Da-da double");
    }
    public static void main(String[] args){
        char a = '5';
        byte b = 5;
        Dog.bark(b, a);
    }
}

