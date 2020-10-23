package com.test.reusing;

public class Cycle {
    public void ride(){
        System.out.println("This is cycle");
    }
    protected int NumberOfWheels = 0;
    protected void wheels()
    {
        System.out.println("Number of wheels: " + NumberOfWheels);
    }

    public static void main(String[] args){
        Unicycle x = new Unicycle();
        Bicycle y = new Bicycle();
        Tricycle z = new Tricycle();
        x.ride(); y.ride(); z.ride();
        x.wheels(); y.wheels(); z.wheels();
    }
}

class Unicycle extends Cycle{
    Unicycle(){
        NumberOfWheels = 1;
    }
}

class Bicycle extends Cycle{
    Bicycle(){
        NumberOfWheels = 2;
    }
}

class Tricycle extends Cycle{
    Tricycle(){
        NumberOfWheels = 3;
    }
}

