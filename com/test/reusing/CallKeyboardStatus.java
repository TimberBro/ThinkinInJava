package com.test.reusing;

import com.test.reusing.device.Keyboard;

public class CallKeyboardStatus extends Keyboard {
  public static void main(String[] args) {
    CallKeyboardStatus k = new CallKeyboardStatus();
    k.printStatus();
  }
}
