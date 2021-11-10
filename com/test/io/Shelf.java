package com.test.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class Shelf implements Serializable {

  private Book[] books;

  Shelf(Book[] books) {
    this.books = new Book[books.length];
    for (int i = 0; i < books.length; i++) {
      this.books[i] = books[i];
    }
  }

  @Override
  public String toString() {
    return "Shelf{" + "books=" + Arrays.toString(books) + '}';
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Shelf shelf = new Shelf(new Book[]{new Book("Alice in Wonderland"), new Book("Little prince"),
        new Book("The Picture of Dorian Grey")});
    System.out.println("Original object\n" + shelf);
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("shelf.out"));
    out.writeObject(shelf);
    out.close();
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("shelf.out"));
    Shelf shelf1 = (Shelf) in.readObject();
    System.out.println("Readed from file\n" + shelf1);
  }
}
