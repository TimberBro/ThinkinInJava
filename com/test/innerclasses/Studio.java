package com.test.innerclasses;

interface Instrument {

  void tune();

  class Guitar {
    static void play(Instrument i) {
      i.tune();
    }
  }
}

public class Studio {
  public static void main(String[] args) {
    Instrument instrument =
        new Instrument() {
          @Override
          public void tune() {
            System.out.println("G_MINOR");
          }
        };

    Instrument.Guitar.play(instrument);
  }
}
