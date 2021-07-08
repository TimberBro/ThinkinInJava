package com.test.exceptions;

public class WithFinally {
  static Switch sw = new Switch();

  public static void main(String[] args) {
    try {
      sw.on();
      OnOffSwitch.f();
    } catch (OnOffException1 e) {
      System.out.println("OnOffExceptionl");
    } catch (OnOffException2 e) {
      System.out.println("0n0ffException2");
    } finally {
      sw.off();
      System.out.println("Current switch state = " + sw.toString());
    }
  }
}
