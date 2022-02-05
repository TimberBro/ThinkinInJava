package com.test.gui;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HelloLabel {

  public static void main(String[] args) throws Exception {
    Random random = new Random(47);
    JFrame frame = new JFrame("Hello Swing");
    JLabel label = new JLabel("A Label");
    frame.add(label);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 100);
    frame.setVisible(true);
    for (int i = 0; i < 10; i++) {
      TimeUnit.SECONDS.sleep(1);
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          label.setText("Hey! This is Different! Number = " + random.nextInt());
        }
      });
    }
  }
}
