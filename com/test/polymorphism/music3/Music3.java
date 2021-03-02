package com.test.polymorphism.music3;

import com.test.polymorphism.music.*;

class Instrument {
  void play(Note n) {
    System.out.println("Instrument.play() " + n);
  }

  @Override
  public String toString() {
    return "Instrument";
  }

  void adjust() {
    System.out.println("Adjusting Instrument");
  }
}

class Wind extends Instrument {
  void play(Note n) {
    System.out.println("Wind.play() " + n);
  }

  @Override
  public String toString() {
    return "Wind";
  }
}

class Percussion extends Instrument {
  void play(Note n) {
    System.out.println("Percussion.play() " + n);
  }

  @Override
  public String toString() {
    return "Percussion";
  }
}

class Stringed extends Instrument {
  void play(Note n) {
    System.out.println("Stringed.play() " + n);
  }

  @Override
  public String toString() {
    return "Stringed";
  }
}

class Guitar extends Instrument {
  void play(Note n) {
    System.out.println("Guitar.play() " + n);
  }

  @Override
  public String toString() {
    return "Guitar";
  }
}

class Brass extends Wind {
  void play(Note n) {
    System.out.println("Brass.play() " + n);
  }

  @Override
  public String toString() {
    return "Brass";
  }
}

class Woodwind extends Wind {
  void play(Note n) {
    System.out.println("Woodwind.play() " + n);
  }

  @Override
  public String toString() {
    return "Woodwind";
  }
}

public class Music3 {
  private static final RandomIntrumentGenerator gen = new RandomIntrumentGenerator();
  public static void tune(Instrument i) {
    i.play(Note.B_FLAT);
  }

  public static void tuneAll(Instrument[] e) {
    for (Instrument i : e) tune(i);
  }

  public static void printAll(Instrument[] e) {
    for (Instrument i : e) System.out.println(i);
  }

  public static void main(String[] args) {

    // Upcasting during addition to the array:
    Instrument[] orchestra = new Instrument[6];
    for (int i = 0; i < orchestra.length; i++) {
      orchestra[i] = gen.next();
    }
    printAll(orchestra);
  }
}
