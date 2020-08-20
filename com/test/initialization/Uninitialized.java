package com.test.initialization;

public class Uninitialized {
     String a;
     public static void main(String[] args){
         Uninitialized x = new Uninitialized();
         System.out.print(x.a);
     }
}
