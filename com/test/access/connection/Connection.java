package com.test.access.connection;

class Connection {
  private static int counter = 0;
  private int id = counter++;

  Connection() {
    System.out.println("Connection created");
  }

  public String toString() {
    return "Connection " + id;
  }
}
