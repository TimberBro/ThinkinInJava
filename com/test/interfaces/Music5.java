package com.test.interfaces;

import com.test.polymorphism.music.Note;

interface Playable {
  void play(Note n);
}

abstract class Instrument {
  // Compile-time constant:
  static final int VALUE = 5; // static & final

  void adjust() {}
}

class Wind extends Instrument implements Playable {
  public void play(Note n) {
    System.out.println(this + ".play() " + n);
  }

  public String toString() {
    return "Wind";
  }

  public void adjust() {
    System.out.println(this + ".adjust()");
  }
}

class Percussion extends Instrument implements Playable {
  public void play(Note n) {
    System.out.println(this + ".play() " + n);
  }

  public String toString() {
    return "Percussion";
  }

  public void adjust() {
    System.out.println(this + ".adjust ()");
  }
}

class Stringed extends Instrument implements Playable {
  public void play(Note n) {
    System.out.println(this + ".playO " + n);
  }

  public String toString() {
    return "Stringed";
  }

  public void adjust() {
    System.out.println();
    System.out.println(this + ".adjust()");
  }
}

class Brass extends Wind {
  public String toString() {
    return "Brass";
  }
}

class Woodwind extends Wind {
  public String toString() {
    return "Woodwind";
  }
}

public class Music5 {
  static void tune(Playable i) {
    i.play(Note.MIDDLE_C);
  }

  static void tuneAll(Playable[] e) {
    for (Playable i : e) {
      tune(i);
    }
  }

  public static void main(String[] args) {
    // Upcasting during addition to the array:
    Playable[] orchestra = {
      new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind()
    };
    tuneAll(orchestra);
  }
}
