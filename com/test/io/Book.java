package com.test.io;

import java.io.Serializable;

public class Book implements Serializable {
  private String title;

  public Book(String s) {
    title = s;
  }

  public Book() {
    System.out.println("Default Book constructor");
  }

  @Override
  public String toString() {
    return "Book{" + "title='" + title + '\'' + '}';
  }
}
