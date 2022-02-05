package com.test.gui;

import javax.swing.JFrame;

public class HelloSwing {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Hello Swing");
    // Program really does not finish after window was closed!
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 100);
    frame.setVisible(true);
  }
}