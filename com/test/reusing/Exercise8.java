package com.test.reusing;

public class Exercise8 {
    Exercise8(int i){
        System.out.println("This is custom Exercise8 constructor with " + i + " argument.");
    }
}
class Derived extends Exercise8{
    Derived(int i) {
        super(1);
        System.out.println("This is custom Derived constructor with " + i + " argument.");
    }
    Derived(){
        super(11);
        System.out.println("This is custom Derived constructor without argument.");
    }
    public static void main(String[] args){
        Derived x = new Derived(2);
        Derived y = new Derived();
    }
}
