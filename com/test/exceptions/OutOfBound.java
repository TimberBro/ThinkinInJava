package com.test.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;


public class OutOfBound {
  private static Logger logger = Logger.getLogger("LoggedIndexOutOfBoundException");

  static void logException(Exception e) {
    StringWriter trace = new StringWriter();
    e.printStackTrace(new PrintWriter(trace));
    logger.severe(trace.toString());
  }

  public static void main(String[] args) {
    int[] ints = new int[5];
    try {
      for (int i = 0; i < 6; i++) {
        ints[i] = i;
      }
    } catch (IndexOutOfBoundsException e) {
      logException(e);
    }
  }
}
