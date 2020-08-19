package com.test.objects;

import java.util.Date;

public class HelloDate {
    String Hello = "Hello, World! Today's date:";
    public static void main(String[] args){
        HelloDate x = new HelloDate();
        System.out.println(x.Hello);
        System.out.println(new Date());
    }
}
