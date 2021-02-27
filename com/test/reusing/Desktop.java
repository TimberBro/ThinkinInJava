package com.test.reusing;

import com.test.reusing.device.Keyboard;

public class Desktop extends Keyboard {
  public static void main(String[] args) {
    Desktop k = new Desktop();
    k.printStatus();
  }
}
