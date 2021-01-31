package com.test.access;

class ConnectionManager {
  static int MaxConnections = 2;
  static int CurrentConnections = 0;

  private ConnectionManager() {
    System.out.println("Connection created");
    CurrentConnections++;
  }

  public static ConnectionManager createConnection() {
    if (CurrentConnections < MaxConnections) {
      return new ConnectionManager();
    } else {
      System.out.println("Number of max connection exceeded");
      return null;
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      createConnection();
    }
  }
}
