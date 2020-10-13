package com.test.polymorphism.music3;
import com.test.polymorphism.music.*;

class Instrument {
    void play(Note n) { System.out.println("Instrument.play() " + n); }
    String what() { return "Instrument"; }
    void adjust() { System.out.println("Adjusting Instrument"); }
}

class Wind extends Instrument {
    void play(Note n) { System.out.println("Wind.play() " + n); }
    String what() { return "Wind"; }
    void adjust() { System.out.println("Adjusting Wind"); }
}
class Percussion extends Instrument {
    void play(Note n) { System.out.println("Percussion.play() " + n);}
            String what() { return "Percussion"; }
        void adjust() { System.out.println("Adjusting Percussion"); }
}

class Stringed extends Instrument {
    void play(Note n) { System.out.println("Stringed.play() " + n); }
    String what() { return "Stringed"; }
    void adjust() { System.out.println ("Adjusting Stringed"); }
}
class Electro extends Instrument{
    void play(Note n ) { System.out.println("Electro.play() " + n); }
    String what() { return "Electro";}
    void adjust() { System.out.println("Adjusting Electro"); }
}

class Brass extends Wind {
    void play(Note n) { System.out.println("Brass.play() " + n); }
    void adjust() { System.out.println ("Adjusting Brass"); }
}

class Woodwind extends Wind {
    void play(Note n) { System.out.println("Woodwind.play() " + n) ; }
    String what() { return "Woodwind"; }
}

public class Music3 {
    private static RandomIntrumentGenerator gen = new RandomIntrumentGenerator();
    // Doesn't care about type, so new types
// added to the system still work right:
    public static void tune(Instrument i) {
        i.play(Note.B_FLAT);
    }

    public static void tuneAll(Instrument[] e) {
        for (Instrument i : e)
            tune(i);
    }
    public static void printWhat(Instrument[] e){
        for (Instrument i : e)
            System.out.println(i.what());
    }

    public static void main(String[] args) {

// Upcasting during addition to the array:
        Instrument[] orchestra = new Instrument[6];
        for (int i = 0; i < orchestra.length; i++){
            orchestra[i] = gen.next();
        }
        tuneAll(orchestra);
        printWhat(orchestra);
    }
}