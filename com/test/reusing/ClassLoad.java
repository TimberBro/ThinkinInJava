package com.test.reusing;

import sun.security.krb5.internal.crypto.Des;

public class ClassLoad {
  public static void main(String[] args) {
    //Class loading by the access of a static member.
    System.out.println("Trying to access the static field");
    System.out.println("Static field value = " + Desk.counter);
    //Class loading by the creation of the first instance of that class
    System.out.println("Trying to access the static field after creating an instance of the class.");
    Desk desk = new Desk();
    System.out.println("Static field value = " + Desk.counter);
  }
}

class Desk {
  static {
    System.out.println("Class loaded.");
  }

  Desk() {
    System.out.println("Instance of the class created.");
  }

  static int counter = 1;
}
