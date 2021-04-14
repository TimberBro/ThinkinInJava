package com.test.holding;

import java.util.ArrayList;

public class Gerbil {
  private int number;

  Gerbil(int i) {
    this.number = i;
  }

  void hop() {
    System.out.println("This is gerbil number = " + number);
    System.out.println("Hop!");
  }

  public static void main(String[] args) {
    ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
    gerbils.add(new Gerbil(1));
    gerbils.add(new Gerbil(2));
    gerbils.add(new Gerbil(3));
    gerbils.add(new Gerbil(4));
    gerbils.add(new Gerbil(5));
    gerbils.add(new Gerbil(6));
    for (Gerbil i : gerbils) {
      i.hop();
    }
  }
}
