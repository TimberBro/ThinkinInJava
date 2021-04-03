package com.test.innerclasses;

class Outer11 {
  private class Square implements Park {

    @Override
    public int countTrees() {
      return 35;
    }
  }

  Park getPark() {
    return new Square();
  }

  Square getSquare() {
    return new Square();
  }
}

public class HiddenImplementation {
  public static void main(String[] args) {
    Outer11 outer = new Outer11();
    Park x = outer.getPark();
    x = outer.getSquare();
    //This will not compile, Square in not visible
    //Square y = outer.getSquare();
    //Square s = (Square) x;
  }
}
