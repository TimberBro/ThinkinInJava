package com.test.strings;

public class RegexTest {

  public static void main(String[] args) {
    String[] tests = {
        "Aajgeiowgjsdjkg gsadlkgjsa   asdg  ag g.",
        "Aajgeiowgjsdjkg gsadlkgjsa   asdg  ag g",
        "aajgeiowgjsdjkg gsadlkgjsa   asdg  ag g.",
        "Aajgeiowgjs.djkg gsadlkg.jsa   a.sdg.  ag g",
        "aajgeiowgjsdjkg gsadlkgjsa   asdg  ag g",
        "A.",
      };

    for (String s : tests) {
      System.out.println(s.matches("^[A-Z].*\\.$"));
    }
  }
}
