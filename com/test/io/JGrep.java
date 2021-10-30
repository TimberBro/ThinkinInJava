package com.test.io;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {

  static int length = 0x8FFFFFF;

  public static void main(String[] args) throws Exception {
    if (args.length < 2) {
      System.out.println("Usage: java JGrep file regex");
      System.exit(0);
    }

    FileChannel fileChannel = new FileInputStream(args[0]).getChannel();
    ByteBuffer byteBuffer = fileChannel.map(MapMode.READ_ONLY, 0, fileChannel.size());
    CharBuffer charBuffer = Charset.forName(System.getProperty("file.encoding")).decode(byteBuffer);
    String[] fileStrings = charBuffer.toString().split("\n");
    Pattern p = Pattern.compile(args[1]);
    // Iterate through the lines of the input file:
    int index = 0;
    Matcher m = p.matcher("");
    for (String line : fileStrings) {
      m.reset(line);
      while (m.find()) {
        System.out.println(index++ + ": " + m.group() + ": " + m.start());
      }
    }
    fileChannel.close();
  }
}
