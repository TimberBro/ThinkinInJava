package com.test.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StoringAndRecoveringData {

  public static void main(String[] args) throws IOException {
    DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(new FileOutputStream("Data.txt")));
    out.writeDouble(3.14159);
    out.writeUTF("That was pi");
    out.writeDouble(1.41413);
    out.writeUTF("Square root of 2");
    out.writeBoolean(true);
    out.writeByte(97);
    out.writeChar(97 - 32);
    out.writeInt(Integer.MAX_VALUE);
    out.writeFloat(12f);
    out.writeLong(12345L);
    out.writeShort(67890);
    out.close();
    DataInputStream in = new DataInputStream(
        new BufferedInputStream(new FileInputStream("Data.txt")));
    System.out.println(in.readDouble());
    // Only readUTF() will recover the
    // Java-UTF String properly:
    // Reading in same order of method gives same result.
    System.out.println(in.readUTF());
    System.out.println(in.readDouble());
    System.out.println(in.readUTF());
    System.out.println(in.readBoolean());
    System.out.println(in.readByte());
    System.out.println(in.readChar());
    System.out.println(in.readInt());
    System.out.println(in.readFloat());
    System.out.println(in.readLong());
    System.out.println(in.readShort());
  }
}
