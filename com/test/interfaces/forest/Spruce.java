package com.test.interfaces.forest;

import com.test.interfaces.garden.Tree;

public class Spruce implements Tree {

  @Override
  public int getHeights() { // attempting to assign weaker access
    // privileges ('package-private'); was 'public'
    return 150;
  }

  @Override
  public int getNumberLeafs() {
    return 12000000;
  }

  @Override
  public void printName() {
    System.out.println("Name = " + this);
  }

  public String toString() {
    return "Spruce";
  }
}
