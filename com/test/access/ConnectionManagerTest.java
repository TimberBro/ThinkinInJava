package com.test.access;

import com.test.access.connection.*;

public class ConnectionManagerTest {
  public static void main(String[] args) {
    ConnectionManager connectionManager = new ConnectionManager();
    System.out.println(connectionManager.getConnection());
    System.out.println(connectionManager.getConnection());
    System.out.println(connectionManager.getConnection());
    System.out.println(connectionManager.getConnection()); // Will return null
    System.out.println(connectionManager.getConnection()); // Will return null
  }
}
