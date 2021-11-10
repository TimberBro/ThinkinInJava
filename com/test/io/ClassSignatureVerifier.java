package com.test.io;

import com.test.util.BinaryFile;
import com.test.util.Directory;
import com.test.util.Directory.TreeInfo;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ClassSignatureVerifier {

  static final byte[] SIGNATURE = {(byte) 202, (byte) 254, (byte) 186, (byte) 190};

  public static void main(String[] args) {
    List<File> fileList = Directory
        .walk("out\\production\\ThinkingInJava", ".*\\.class").files;

    for (File file : fileList) {
      try {
        byte[] bytes = BinaryFile.read(file);
        for (int i = 0; i < SIGNATURE.length; i++) {
          if (bytes[i] != SIGNATURE[i]) {
            System.out.println(file + " is broken.");
            break;
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
