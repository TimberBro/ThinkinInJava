package com.test.polymorphism.animals;

public class Rodent {
    void squeak(){
        System.out.println("Squeak!");
    }
    void type(){
        System.out.println("Base type");
    }

    public static void main(String[] args){
        Rodent[] rodents = new Rodent[3];
        rodents[0] = new Mouse();
        rodents[1] = new Gerbil();
        rodents[2] = new Hamster();
        for (int i = 0; i < rodents.length; i++){
            rodents[i].type();
        }
    }
}

class Mouse extends Rodent{
    void type(){
        System.out.println("This is mouse");
    }
}

class Gerbil extends Rodent{
    void type(){
        System.out.println("This is gerbil");
    }
}

class Hamster extends Rodent{
    void type(){
        System.out.println("This is hamster");
    }
}
