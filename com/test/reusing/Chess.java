package com.test.reusing;

class Game {
  Game(int i) {
    System.out.println("Game constructor " + i);
  }
}

class BoardGame extends Game {
  BoardGame(int i) {
    super(i);
    System.out.println("BoardGame constructor " + i);
  }
}

public class Chess extends BoardGame {
  Chess(int i) {
    super(11);
    System.out.println("Chess constructor " + i);
  }

  public static void main(String[] args) {
    Chess x = new Chess(1);
  }
}
