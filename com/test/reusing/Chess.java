package com.test.reusing;

class Game {
  Game(int i) {
    System.out.println("Game constructor");
  }
}

class BoardGame extends Game {
  BoardGame(int i) {
    super(i);
    // super(i) - method, calling non-default constructor of base-class.
    // There is no default constructor available in Game class.
    // Compiler will tell you, that it can't find a proper constructor for Game
    System.out.println("BoardGame constructor");
  }
}

public class Chess extends BoardGame {
  Chess() {
    super(11);
    System.out.println("Chess constructor");
  }

  public static void main(String[] args) {
    Chess x = new Chess();
  }
}
