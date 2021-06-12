package com.test.strings;

import com.test.util.TextFile;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {

  static void examine(Pattern p, File file) throws IOException {
    int index = 0;
    Matcher m = p.matcher("");
    for (String line : new TextFile(file.getCanonicalPath())) {
      m.reset(line);
      while (m.find()) {
        System.out.println(index++ + ": " + m.group() + ": " + m.start());
      }
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 2) {
      System.out.println("Usage: java JGrep file regex flag");
      System.out.println(
          "Accepted flags: UNIX_LINES, CASE_INSENSITIVE, COMMENTS, MULTILINE, LITERAL, DOTALL, "
              + "UNICODE_CASE, CANON_EQ, UNICODE_CHARACTER_CLASS");
      System.exit(0);
    }
    Pattern p;
    if (args.length > 2) {
      switch (args[2]) {
        case ("UNIX_LINES"):
          p = Pattern.compile(args[1], Pattern.UNIX_LINES);
          break;
        case ("CASE_INSENSITIVE"):
          p = Pattern.compile(args[1], Pattern.CASE_INSENSITIVE);
          break;
        case ("COMMENTS"):
          p = Pattern.compile(args[1], Pattern.COMMENTS);
          break;
        case ("MULTILINE"):
          p = Pattern.compile(args[1], Pattern.MULTILINE);
          break;
        case ("LITERAL"):
          p = Pattern.compile(args[1], Pattern.LITERAL);
          break;
        case ("DOTALL"):
          p = Pattern.compile(args[1], Pattern.DOTALL);
          break;
        case ("UNICODE_CASE"):
          p = Pattern.compile(args[1], Pattern.UNICODE_CASE);
          break;
        case ("CANON_EQ"):
          p = Pattern.compile(args[1], Pattern.CANON_EQ);
          break;
        case ("UNICODE_CHARACTER_CLASS"):
          p = Pattern.compile(args[1], Pattern.UNICODE_CHARACTER_CLASS);
          break;
      }
    }
    p = Pattern.compile(args[1]);
    // Iterate through the lines of the input file:
    if (new File(args[0]).isDirectory()) {
      File[] files = new File(args[0]).listFiles();
      for (File file : files) {
        System.out.println("Working with file: " + file.getCanonicalFile());
        examine(p, file);
      }
    } else {
      examine(p, new File(args[0]));
    }
  }
}
