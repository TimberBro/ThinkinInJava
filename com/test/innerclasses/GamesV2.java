package com.test.innerclasses;

import java.util.Random;

interface TossGame {
  void toss();
}

interface TossGameFactory {
  TossGame getTossGame();
}

class Coin implements TossGame {

  private Coin() {}

  public static TossGameFactory factory =
      new TossGameFactory() {
        @Override
        public TossGame getTossGame() {
          return new Coin();
        }
      };

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

class Dice implements TossGame {
  private Dice() {}

  public static TossGameFactory factory =
      new TossGameFactory() {
        @Override
        public TossGame getTossGame() {
          return new Dice();
        }
      };

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

public class GamesV2 {

  public static void playGame(TossGameFactory factory) {
    TossGame tossGame = factory.getTossGame();
    tossGame.toss();
  }

  public static void main(String[] args) {
    playGame(Coin.factory);
    playGame(Dice.factory);
  }
}
