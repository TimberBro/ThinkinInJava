package com.test.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise10 {
  public static void main(String[] args) {
    String string = "Java now has regular expressions";
    String[] regexps = {
      "^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?", "s*", "s+", "s{4}", "s{1}", "s{0,3}",
      };
    for (String pattern : regexps) {
      System.out.println("Current regex: " + pattern);
      Pattern p = Pattern.compile(pattern);
      Matcher m = p.matcher(string);
      while (m.find()) {
        System.out.println(
            "Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
      }
    }
  }
}
