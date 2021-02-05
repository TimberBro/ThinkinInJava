package com.test.reusing;

public class LazyInitialization {

  Glass glass;

  void printStatus() {
    if (glass == null) {
      glass = new Glass();
      glass.status = "Broken";
    }
    System.out.println(glass.toString());
  }

  public static void main(String[] args) {
    LazyInitialization x = new LazyInitialization();
    x.printStatus();
  }
}

class Glass {
  String status;

  Glass() {
    System.out.println("Object created, status = " + status);
  }

  public String toString() {
    return "Glass{" + "status='" + status + "'" + "}";
  }
}
