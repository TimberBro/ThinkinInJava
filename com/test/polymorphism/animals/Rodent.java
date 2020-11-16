package com.test.polymorphism.animals;

public class Rodent {
    private int refcount = 0;
    private static int counter = 0;
    private final int id = counter++;
    void squeak(){
        System.out.println("Squeak!");
    }
    void type(){
        System.out.println("Base type");
    }
    Rodent(){
        System.out.println("Creating " + this);
    }
    public String toString(){
        return ("Rodent " + id);
    }
    public void addRef(){
        refcount++;
    }
    protected void dispose(){
        if(--refcount == 0){
            System.out.println("Disposing " + id);
        }
    }

    public static void main(String[] args){
        System.out.println("Array declared");
        Rodent rodent = new Rodent();
        Rodent[] rodents = {
                new Hamster(rodent),
                new Hamster(rodent),
                new Hamster(rodent),
                new Hamster(rodent)};
        System.out.println("Array filled");
        for (Rodent value : rodents) {
            value.dispose();
            value.squeak();
            value.type();
        }
    }
}

class Mouse extends Rodent{
    void type(){
        System.out.println("This is mouse");
    }
    Mouse(){
        System.out.println("Mouse constructor");
    }
}

class Gerbil extends Rodent{
    void type(){
        System.out.println("This is gerbil");
    }
    Gerbil(){
        System.out.println("Gerbil constructor");
    }
}

class Hamster extends Rodent{
    private final Rodent rodent;
    private static int counter = 0;
    private final int id = counter++;
    void type(){
        System.out.println("This is hamster");
    }

    Hamster(Rodent rodent){
        //System.out.println("Creating " + this);
        this.rodent = rodent;
        this.rodent.addRef();
    }
    protected void dispose(){
        System.out.println("Disposing " + this);
        rodent.dispose();
    }
    public String toString() {
        return ("Hamster " + id);}
}

class Syrian extends Hamster{
    void type(){
        System.out.println("This is Syrian Hamster");
    }
    Syrian(Rodent rodent){
        super(rodent);
        System.out.println("Syrian Hamster constructor");
    }
}
