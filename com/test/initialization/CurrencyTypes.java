package com.test.initialization;

public class CurrencyTypes {
  public enum Currency {
    FIVE,
    TEN,
    FIFTY,
    HUNDRED,
    TWO_HUNDREDS,
    FIVE_HUNDREDS
  }

  public static void main(String[] args) {
    for (Currency currency : Currency.values()) {
      System.out.println(
          "This is paper currency: " + currency + " RUR. And ordinal is: " + currency.ordinal());
      switch (currency) {
        case FIVE:
          System.out.println("Has a sight of Veliky Novgorod on it.");
          break;
        case TEN:
          System.out.println("Has a sight of Krasnoyarsk on it.");
          break;
        case FIFTY:
          System.out.println("Has a sight of Saint Petersburg on it.");
          break;
        case HUNDRED:
          System.out.println("Has a sight of Moscow on it.");
          break;
        case TWO_HUNDREDS:
          System.out.println("Has a sight of Sevastopol on it.");
          break;
        case FIVE_HUNDREDS:
          System.out.println("Has a sight of Arkhangelsk on it.");
          break;
        default:
          System.out.println("Has a sight of another city on it.");
          break;
      }
    }
  }
}
