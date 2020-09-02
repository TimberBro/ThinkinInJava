package com.test.initialization;

class Rabbit{
    Rabbit(int marker){
        System.out.println("There is " + marker + " Rabbit on the field");
    }
}
class Rabbits{
    Rabbit rabbit1;
    Rabbit rabbit2;
    {
        rabbit1 = new Rabbit(1);
        rabbit2 = new Rabbit(2);
        System.out.println("Rabbit1 and rabbit2 initialized");
    }
    Rabbits(){
        System.out.println("This is constructor");
    }
    Rabbits(int x){
        System.out.println("This is overloaded constructor with int argument");
    }
}
public class Exercise15 {
    public static void main (String[] args){
        new Rabbits();
        System.out.println("First objects initialized");
        new Rabbits(22);
        System.out.println("Second objects initialized");
    }
}
