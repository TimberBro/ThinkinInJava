package com.test.access.connection;

public class ConnectionManager {
  private static class ConnectionImpl implements Connection {
    private static int counter = 0;
    private int id = counter++;

    ConnectionImpl() {
      System.out.println("Connection created");
    }

    public String toString() {
      return "Connection " + id;
    }
  }

  private static Connection[] pool = new ConnectionImpl[3];
  private static int counter = 0;

  static {
    for (int i = 0; i < pool.length; i++) {
      pool[i] = new ConnectionImpl();
    }
  }

  public static Connection getConnection() {
    if (counter < pool.length) {
      System.out.println("Connection issued. ID = " + pool[counter]);
      return pool[counter++];
    } else {
      System.out.println("Number of max connection exceeded.");
      return null;
    }
  }
}
