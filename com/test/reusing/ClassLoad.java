package com.test.reusing;

public class ClassLoad {

  // Main method to prove, that loading may be caused by
  // the creating of the first instance of that class.
  public static void main(String arg) {
    Desk desk = new Desk();
  }

  // Main method to prove, that loading may be caused by
  // access of a static member.
  public static void main(Integer arg) {
    System.out.println(Desk.counter);
  }

  // Main method to prove, that class loading takes place only once.
  public static void main(String[] args) {
    System.out.println("Load class by access of a static member");
    System.out.println("Static field value = " + Desk.counter);
    // Creating an instance of the class will not load class one more time
    Desk desk = new Desk();
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
