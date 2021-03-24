package com.test.interfaces.interfaceprocessor;

public class StringProcessor implements Processor {

  @Override
  public String name() {
    return getClass().getSimpleName();
  }

  public static String swapPairsCharacters(String s) {
    char[] charArray = new char[s.length()];
    if (s.length() % 2 == 0) {
      for (int i = 0; i < s.length() - 1; i += 2) {
        charArray[i] = s.charAt(i + 1);
        charArray[i + 1] = s.charAt(i);
      }
      return new String(charArray);
    } else {
      for (int i = 0; i < s.length() - 1; i += 2) {
        charArray[i] = s.charAt(i + 1);
        charArray[i + 1] = s.charAt(i);
      }
      charArray[s.length() - 1] = s.charAt(s.length() - 1);
      return new String(charArray);
    }
  }

  public String process(Object input) {
    return swapPairsCharacters((String) input);
  }

  public static String s = "abcde";

  public static void main(String[] args) {
    Apply.process(new StringProcessor(), s);
  }
}
