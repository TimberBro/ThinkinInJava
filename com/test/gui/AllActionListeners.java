package com.test.gui;

import com.test.util.SwingConsole;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class AllActionListeners extends JFrame {
  JPanel panel = new JPanel();
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();

  JComboBox<String> comboBox = new JComboBox<>(new String[]{"Hello", "World", "!"});
  JTextField comboBoxResult = new JTextField(10);
  JToggleButton toggleButton = new JToggleButton();
  ActionListener timerListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      JLabel label = new JLabel("Created by timer");
      panel2.add(label);
      add(panel2);
    }
  };

  ActionListener toggleListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      panel2.setVisible(!panel2.isVisible());
    }
  };

  ActionListener comboBoxListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      JComboBox<String> cb = (JComboBox<String>) e.getSource();
      comboBoxResult.setText(cb.getSelectedItem().toString());
    }
  };
  Timer timer = new Timer(100, timerListener);
  JFileChooser fileChooser = new JFileChooser();
  JTextField fileTextField = new JTextField(10);
  ActionListener fileChooserListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      JFileChooser fileChooser = (JFileChooser) e.getSource();
      fileTextField.setText(fileChooser.getSelectedFile().getName());
    }
  };

  public AllActionListeners() {
    setLayout(new FlowLayout());
    comboBox.addActionListener(comboBoxListener);
    panel.add(comboBox);
    toggleButton.addActionListener(toggleListener);
    panel.add(toggleButton);
    panel2.add(comboBoxResult);
    add(panel);
    timer.setRepeats(false);
    timer.start();
    fileChooser.addActionListener(fileChooserListener);
    panel1.add(fileChooser);
    panel1.add(fileTextField);
    add(panel1);
  }


  public static void main(String[] args) {
    SwingConsole.run(new AllActionListeners(), 300, 100);
  }

}
