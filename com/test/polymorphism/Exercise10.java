package com.test.polymorphism;


public class Exercise10 {
    void print1(){
        print2();
    }
    void print2(){
        System.out.println("Called from first method");
    }
    public static void main(String[] args){
        Overriden n = new Overriden();
        n.print1();
    }
}
class Overriden extends Exercise10{
    void print2() {
        System.out.println("Overriden from child class");
    }
}

