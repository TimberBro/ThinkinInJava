package com.test.strings;

public class Exercise6 {
  int i = 1000;
  long lg = 100L;
  float ft = 538.2577858f;
  double dbl = 24.533;

  @Override
  public String toString() {
    StringBuilder string = new StringBuilder();
    string.append(String.format("int = %d; \n", i));
    string.append(String.format("long = %d; \n", lg));
    string.append(String.format("float = %.2f; \n", ft));
    string.append(String.format("double = %.2f; \n", dbl));
    return string.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Exercise6());
  }
}
