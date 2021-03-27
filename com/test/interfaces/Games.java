package com.test.interfaces;

import java.util.Random;

interface TossGame {
  void toss();
}

interface TossGameFactory {
  TossGame getTossGame();
}

class Coin implements TossGame {

  @Override
  public void toss() {
    Random random = new Random();
    if (random.nextBoolean()) {
      System.out.println("Heads!");
    } else {
      System.out.println("Tails!");
    }
  }
}

class CoinFactory implements TossGameFactory {

  @Override
  public TossGame getTossGame() {
    return new Coin();
  }
}

class Dice implements TossGame {

  @Override
  public void toss() {
    Random random = new Random();
    System.out.println(
        "First dice = "
            + (random.nextInt(6) + 1)
            + " , second dice = "
            + (random.nextInt(6) + 1)
            + ".");
  }
}

class DiceFactory implements TossGameFactory {

  @Override
  public TossGame getTossGame() {
    return new Dice();
  }
}

public class Games {

  public static void playGame(TossGameFactory factory) {
    TossGame tossGame = factory.getTossGame();
    tossGame.toss();
  }

  public static void main(String[] args) {
    playGame(new CoinFactory());
    playGame(new DiceFactory());
  }
}
