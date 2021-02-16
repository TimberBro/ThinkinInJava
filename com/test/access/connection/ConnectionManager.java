package com.test.access.connection;

public class ConnectionManager {
  static Connection[] pool = new Connection[3];
  static int counter = 0;

  static {
    for (int i = 0; i < pool.length; i++) {
      pool[i] = new Connection();
    }
  }

  public Connection getConnection() {
    if (counter < pool.length) {
      System.out.println("Connection issued.");
      return pool[counter++];
    } else {
      System.out.println("Number of max connection exceeded.");
      return null;
    }
  }
}
