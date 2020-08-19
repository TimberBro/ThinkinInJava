package com.test.objects;

public class Storage {
    String test;
    int storage(String s) {
        return s.length() * 2;
    }
    public static void main(String[] args){
        Storage x = new Storage();
        x.test = "Ебануться";
        System.out.println(x.storage(x.test));
    }
}
