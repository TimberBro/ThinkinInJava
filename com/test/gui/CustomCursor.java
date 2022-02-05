package com.test.gui;

import com.test.util.SwingConsole;
import java.awt.Cursor;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class Cursors extends JFrame {

  JTextField txt = new JTextField(10);
  JButton b1 = new JButton("Button 1");
  Cursor hand = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);

  public Cursors() {
    setLayout(new FlowLayout());
    add(txt);
    txt.setCursor(hand);
    add(b1);
    setCursor(hand);
  }
}

public class CustomCursor {

  public static void main(String args[]) {
    SwingConsole.run(new Cursors(), 200, 100);
  }
}