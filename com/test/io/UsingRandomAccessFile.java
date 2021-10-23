package com.test.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {

  static String file = "rtest.dat";

  static void display() throws IOException {
    RandomAccessFile rf = new RandomAccessFile(file, "r");
    for (int i = 0; i < 7; i++) {
      System.out.println("Value " + i + ": " + rf.readDouble());
    }
    System.out.println(rf.read());
    System.out.println(rf.readBoolean());
    System.out.println(rf.readByte());
    System.out.println(rf.readChar());
    System.out.println(rf.readFloat());
    System.out.println(rf.readLong());
    System.out.println(rf.readInt());
    System.out.println(rf.readShort());
    System.out.println(rf.readUTF());
    rf.close();
  }

  public static void main(String[] args) throws IOException {
    RandomAccessFile rf = new RandomAccessFile(file, "rw");
    for (int i = 0; i < 7; i++) {
      rf.writeDouble(i * 1.414);
    }
    rf.write(97);
    rf.writeBoolean(true);
    rf.writeByte(12);
    rf.writeChar(97 - 32);
    rf.writeFloat(12f);
    rf.writeLong(12345L);
    rf.writeInt(Integer.MAX_VALUE);
    rf.writeShort(Short.MAX_VALUE);
    rf.writeUTF("The end of the file");
    rf.close();
    display();
    rf = new RandomAccessFile(file, "rw");
    // Double takes 8 bytes. When you need fifth value, you need to multiply 5 by 8 bytes
    rf.seek(5 * 8);
    rf.writeDouble(47.0001);
    rf.close();
    display();
  }
}
