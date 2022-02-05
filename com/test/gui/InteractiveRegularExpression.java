package com.test.gui;

import com.test.util.SwingConsole;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InteractiveRegularExpression extends JFrame {

  JPanel panel = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel panel3 = new JPanel();
  JTextArea textArea = new JTextArea(10, 10);
  JTextField regexpField = new JTextField(10);
  JTextField resultField = new JTextField(10);
  JButton matchButton = new JButton("Match");
  ActionListener listener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      String input = textArea.getText();
      String expression = regexpField.getText();
      Pattern p = Pattern.compile(expression);
      Matcher m = p.matcher(input);
      String outputS = "";
      while (m.find()) {
        outputS +=
            "Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1) + '\n';
      }
      resultField.setText(outputS);
    }
  };

  public InteractiveRegularExpression() {
    panel.add(textArea);
    panel.add(new JScrollPane(textArea));
    setLayout(new FlowLayout());
    add(panel);
    panel2.add(regexpField);
    add(panel2);
    panel3.add(resultField);
    panel3.add(new JScrollPane(resultField));
    add(panel3);
    matchButton.addActionListener(listener);
    add(matchButton);
  }

  public static void main(String[] args) {
    SwingConsole.run(new InteractiveRegularExpression(), 500, 300);
  }
}
