package com.test.exceptions;

import java.io.*;

public class MainException {
  // Pass all exceptions to the console:
  public static void main(String[] args) throws Exception {
    // Open the file:
    FileInputStream file = new FileInputStream("abc.txt");
    /*
    Exception in thread "main" java.io.FileNotFoundException: abc.txt (The system cannot find the file specified)
	    at java.io.FileInputStream.open0(Native Method)
	    at java.io.FileInputStream.open(FileInputStream.java:195)
	    at java.io.FileInputStream.<init>(FileInputStream.java:138)
	    at java.io.FileInputStream.<init>(FileInputStream.java:93)
	    at com.test.exceptions.MainException.main(MainException.java:9)
     */
    file.close();
  }
}
