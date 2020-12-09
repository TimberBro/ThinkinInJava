package com.test.objects;

public class Overloading {

  /**
   * Main method of the program.
   */
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      Tree t = new Tree(i);
      t.info();
      t.info("overloaded method");
    }
    // Overloaded constructor;
    new Tree();
  }
}

class Tree {
  int height;

  /**
   * This is constructor.
   */
  Tree() {
    System.out.println("Planting a seedling");
    height = 0;
  }

  /**
   * This is constructor with an argument required.
   *
   * @param initialHeight Height of the tree.
   */
  Tree(int initialHeight) {
    height = initialHeight;
    System.out.println("Creating new Tree that is " + height + " feet tall");
  }

  /**
   * Method will print height of the tree.
   */
  void info() {
    System.out.println("Tree is " + height + " feet tall");
  }

  /**
   * Method will print inputted argument, then will print height of the tree.

   * @param s String that will be printed before height of the tree.
   */
  void info(String s) {
    System.out.println(s + ": Tree is " + height + " feet tall");
  }
}


