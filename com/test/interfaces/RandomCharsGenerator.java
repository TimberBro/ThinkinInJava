package com.test.interfaces;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomCharsGenerator {
  private static Random random = new Random();

  public static char randomChar() {
    // ASCII table characters from 'Space' up to '~' including.
    return (char) (32 + random.nextInt(94));
  }

  public static char[] generateRandomChars(char[] charArray) {
    int i = 0;
    while (i < charArray.length) {
      charArray[i] = randomChar();
      i++;
    }
    return charArray;
  }

  public static void main(String[] args) {
    char[] array = new char[10];
    System.out.println(RandomCharsGenerator.generateRandomChars(array));
  }
}

class AdapterRandomCharsGenerator implements Readable {
  private int count;

  AdapterRandomCharsGenerator(int count) {
    this.count = count;
  }

  @Override
  public int read(CharBuffer cb) {
    if (count-- == 0) {
      return -1;
    }
    for (int i = 0; i < 10; i++) {
      cb.append(RandomCharsGenerator.randomChar());
    }
    cb.append(" ");
    return 10;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(new AdapterRandomCharsGenerator(12));
    while (s.hasNext()) {
      System.out.println(s.next());
    }
  }
}
