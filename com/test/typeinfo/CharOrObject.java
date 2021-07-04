package com.test.typeinfo;

public class CharOrObject {
  public static void main(String[] args) {
    char[] chars = "HelloWorld".toCharArray();
    System.out.println("chars.getClass() = " + chars.getClass());
    System.out.println("chars.getClass().getSuperclass() = " + chars.getClass().getSuperclass());
    System.out.println("chars[0].getClass() = char cannot be dereferenced");

    // Array of characters is a real object, but char is not a real object.
  }
}
