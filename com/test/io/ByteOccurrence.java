package com.test.io;

import com.test.util.BinaryFile;
import com.test.util.TextFile;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ByteOccurrence {

  static Map<Byte, Integer> countBytes(String fileName) throws IOException {
    Map<Byte, Integer> bytesMap = new HashMap<>();
    byte[] bytes = BinaryFile.read(fileName);
    for (Byte b : bytes) {
      if (bytesMap.get(b) == null) {
        bytesMap.put(b, 1);
      } else {
        int ref = bytesMap.get(b);
        bytesMap.put(b, ++ref);
      }
    }
    return bytesMap;
  }

  public static void main(String[] args) {
    try {
      System.out.println(countBytes("com\\test\\io\\ByteOccurrence.java"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
