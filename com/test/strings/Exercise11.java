package com.test.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise11 {
  public static void main(String[] args) {
    String string = " Arline ate eight apples and one orange while Anita hadn't any";
    String regex = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
    Pattern p = Pattern.compile(regex);
    Matcher matcher = p.matcher(string);
    while (matcher.find()) {
      System.out.println(
          "Match \""
              + matcher.group()
              + "\" at positions "
              + matcher.start()
              + "-"
              + (matcher.end() - 1));
    }
  }
}
