package com.test.typeinfo;

interface Instrument {
  void play();

  @Override
  public String toString();

  void prepareInstrument();
}

class Wind implements Instrument {
  public void play() {
    System.out.println("Wind.play() ");
  }

  @Override
  public String toString() {
    return "Wind";
  }

  void clearSpitValves() {
    System.out.println("Wind.clearSpitValves");
  }

  @Override
  public void prepareInstrument() {
    clearSpitValves();
  }
}

class Percussion implements Instrument {
  public void play() {
    System.out.println("Percussion.play() ");
  }

  @Override
  public String toString() {
    return "Percussion";
  }

  @Override
  public void prepareInstrument() {
    System.out.println("Percussion prepared.");
  }
}

class Stringed implements Instrument {
  public void play() {
    System.out.println("Stringed.play() ");
  }

  @Override
  public String toString() {
    return "Stringed";
  }

  @Override
  public void prepareInstrument() {
    System.out.println("Stringed prepared.");
  }
}

class Guitar extends Stringed {
  public void play() {
    System.out.println("Guitar.play() ");
  }

  @Override
  public String toString() {
    return "Guitar";
  }

  @Override
  public void prepareInstrument() {
    System.out.println("Guitar prepared.");
  }
}

class Brass extends Wind {
  public void play() {
    System.out.println("Brass.play() ");
  }

  @Override
  public String toString() {
    return "Brass";
  }

  void clearSpitValves() {
    System.out.println("Brass.clearSpitValves");
  }
}

class Woodwind extends Wind {
  public void play() {
    System.out.println("Woodwind.play() ");
  }

  @Override
  public String toString() {
    return "Woodwind";
  }

  void clearSpitValves() {
    System.out.println("Woodwind.clearSpitValves");
  }
}

public class Music {
  static void tune(Instrument i) {
    i.play();
  }

  static void tuneAll(Instrument[] e) {
    for (Instrument instrument : e) {
      tune(instrument);
    }
  }

  static void prepareAll(Instrument[] e) {
    for (Instrument instrument : e) {
      instrument.prepareInstrument();
    }
  }

  public static void main(String[] args) {
    Instrument[] orchestra = {
      new Wind(), new Percussion(),
      new Stringed(), new Brass(),
      new Woodwind(),
      };
    Music.prepareAll(orchestra);
    Music.tuneAll(orchestra);
  }
}
