package com.test.access;

class Leaf {
  Tree n = new Tree();

  void changeNumberOfBranches() {
    n.branches = 5;
    System.out.println(n.branches);
  }
}

public class Tree {
  protected int branches;

  public static void main(String[] args) {
    Leaf branch = new Leaf();
    branch.changeNumberOfBranches();
  }
}
