package com.test.gui;

import com.test.util.SwingConsole;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Button2 extends JFrame {

  private JButton b1 = new JButton("Hello");
  private JButton b2 = new JButton("World");
  private JButton b3 = new JButton("!");
  private JTextField txt = new JTextField(10);
  private ActionListener listener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      String name = ((JButton) e.getSource()).getText();
      txt.setText(name);
    }
  };

  public Button2() {
    b1.addActionListener(listener);
    b2.addActionListener(listener);
    b3.addActionListener(listener);
    setLayout(new FlowLayout());
    add(b1);
    add(b2);
    add(b3);
    add(txt);
  }

  public static void main(String[] args) {
    SwingConsole.run(new Button2(), 300, 300);
  }
}
