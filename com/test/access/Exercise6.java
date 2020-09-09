package com.test.access;

class Leaf{
    Exercise6 n = new Exercise6();
    public void man(){
        n.x = 5;
        System.out.println(n.x);
    }
}

public class Exercise6 {
    protected int x;
    public static void main(String[] args){
        Leaf x = new Leaf();
        x.man();
    }
}
