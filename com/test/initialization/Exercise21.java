package com.test.initialization;

public class Exercise21 {
  public enum Currency {
    RUR,
    USD,
    EUR,
    TUR,
    CAD,
    AUS,
    KR
  }

  public static void main(String[] args) {
    for (Currency x : Currency.values()) {
      System.out.println("This is currency :" + x + ". And ordinal is :" + x.ordinal());
      switch (x) {
        case RUR:
          System.out.println("Russian ruble");
          break;
        case KR:
          System.out.println("Swedish krona");
          break;
        case AUS:
          System.out.println("Australian dollar");
          break;
        case CAD:
          System.out.println("Canadian dollar");
          break;
        case EUR:
        case TUR:
        case USD:
        default:
          System.out.println("Another currency");
          break;
      }
    }
  }
}
