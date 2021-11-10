package com.test.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class PrintableCharBuffer {

  static void print(CharBuffer buff) {
    for (int i = 0; i < buff.length(); i++) {
      char c = buff.charAt(i);
      if (c >= (char) 32 && c < (char) 176) {
        System.out.print(buff.charAt(i));
      } else {
        break;
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    CharBuffer buffer = ByteBuffer.allocate(16).asCharBuffer();
    buffer.put("ABCDE" + (char) 0x01 + "FG");
    buffer.rewind();
    System.out.println(buffer); // Print everything
    print(buffer);
    System.out.println(buffer); // Print printable
  }
}
