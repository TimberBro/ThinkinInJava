package com.test.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Ocean {
  public static void serve(BigFish bigFish, LittleFish littleFish) {
    System.out.println(littleFish + " was eaten by " + bigFish);
  }

  public static void main(String[] args) {
    Random rand = new Random(47);
    Queue<LittleFish> victims = new LinkedList<LittleFish>();
    Generators.fill(victims, LittleFish.generator(), 15);
    List<BigFish> slayers = new ArrayList<BigFish>();
    Generators.fill(slayers, BigFish.generator, 4);
    for (LittleFish fish : victims) {
      serve(slayers.get(rand.nextInt(slayers.size())), fish);
    }
  }
}
