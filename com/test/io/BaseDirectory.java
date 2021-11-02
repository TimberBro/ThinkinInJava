package com.test.io;

import java.util.Scanner;
import java.util.prefs.Preferences;

public class BaseDirectory {

  public static void main(String[] args) {
    Preferences prefs = Preferences.userNodeForPackage(BaseDirectory.class);
    String dir = prefs.get("base directory", "Empty");
    System.out.println("Current base directory value: " + dir);
    System.out.print("Enter new value: ");
    Scanner in = new Scanner(System.in);
    dir = in.nextLine();
    prefs.put("base directory", dir);
    System.out.println("New value of base directory: " + prefs.get("base directory", "Empty"));
  }
}
