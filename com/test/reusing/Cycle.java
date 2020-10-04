package com.test.reusing;

public class Cycle {
    public void ride(){
        System.out.println("This is cycle");
    }

    public static void main(String[] args){
        Unicycle x = new Unicycle();
        Bicycle y = new Bicycle();
        Tricycle z = new Tricycle();
        x.ride(); y.ride(); z.ride();
    }
}

class Unicycle extends Cycle{
}

class Bicycle extends Cycle{

}

class Tricycle extends Cycle{

}

