package com.test.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class Exception1 extends Exception {
  private static Logger logger = Logger.getLogger("LoggingException1");

  public Exception1() {
    StringWriter trace = new StringWriter();
    printStackTrace(new PrintWriter(trace));
    logger.severe(trace.toString());
  }
}

class Exception2 extends Exception {
  private static Logger logger = Logger.getLogger("LoggingException2");

  public Exception2() {
    StringWriter trace = new StringWriter();
    printStackTrace(new PrintWriter(trace));
    logger.severe(trace.toString());
  }
}

public class LoggingExceptions {
  public static void main(String[] args) {
    try {
      throw new Exception1();
    } catch (Exception1 e) {
      System.err.println(e);
    }
    try {
      throw new Exception2();
    } catch (Exception2 e) {
      System.err.println(e);
    }
  }
}
