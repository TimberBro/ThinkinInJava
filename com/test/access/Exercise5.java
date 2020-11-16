package com.test.access;

public class Exercise5 {
    public int a = 1;
    protected int b = 2;
    private final int c = 3;
    public void pub(){
        System.out.println("This is public method");
    }
    protected void prot(){
        System.out.println("This is protected method");
    }
    private void priv(){
        System.out.println("This is private method");
    }
    public static void main(String[] args){
        Exercise5 X = new Exercise5();
        System.out.println(X.a);
        System.out.println(X.b);
        System.out.println(X.c);
        X.pub();
        X.prot();
        X.priv();
    }
}
