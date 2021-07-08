package com.test.exceptions;

class BrokenWireException extends Exception {}

class Earphone {
  Earphone() throws BrokenWireException {
    throw new BrokenWireException();
  }
}

class WirelessEarphone extends Earphone {

  WirelessEarphone() throws BrokenWireException {}

  // Code will not be compiled because of:
  // unreported exception com.test.exceptions.BrokenWireException; must be caught or declared to be
  // thrown
}

public class Phone {
  public static void main(String[] args) {
    try {
      WirelessEarphone we = new WirelessEarphone();
    } catch (BrokenWireException e) {
      e.printStackTrace();
    }
  }
}
