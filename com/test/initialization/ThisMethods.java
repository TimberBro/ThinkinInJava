package com.test.initialization;


public class ThisMethods {
    public void firstMethod(){
        secondMethod();
        this.secondMethod();
    }
    public void secondMethod(){

    }
    public static void main(String[] args){
        ThisMethods x = new ThisMethods();
        x.firstMethod();
    }
}
