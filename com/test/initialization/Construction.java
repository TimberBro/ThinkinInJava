package com.test.initialization;

public class Construction {
  Construction() {
    System.out.println("Default constructor without any argument");
  }

  Construction(String I) {
    System.out.println("Overloaded constructor, that took: \"" + I + "\" argument");
  }

  public static void main(String[] args) {
    Construction X = new Construction("This");
  }
}
