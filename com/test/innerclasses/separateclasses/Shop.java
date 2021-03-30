package com.test.innerclasses.separateclasses;

public class Shop {
  public static void main(String[] args) {
    Keyboard keyboard = new Keyboard();
    Keyboard.KeyCaps kc = keyboard.new KeyCaps(120,"Black");
  }
}
