package com.test.access;

class Connection {
  static int currentConnections = 0;

  private Connection() {
    System.out.println("Connection created");
  }

  static Connection createConnection() {
    currentConnections++;
    return new Connection();
  }
}

class ConnectionManager {

  static int maxConnections = 3;

  Connection[] connections = new Connection[maxConnections];

  {
    for (int i = 0; i < maxConnections; i++) {
      connections[i] = Connection.createConnection();
    }
  }

  public Connection getConnection() {
    if (maxConnections > 0) {
      System.out.println("Connection given.");
      return connections[--maxConnections];
    } else {
      System.out.println("Number of max connection exceeded.");
      return null;
    }
  }

  public static void main(String[] args) {
    ConnectionManager connectionManager = new ConnectionManager();
    System.out.println("You can take " + maxConnections + " connections.");
    System.out.println(connectionManager.getConnection());
    System.out.println("Now you can take " + maxConnections + " connections.");
    System.out.println(connectionManager.getConnection());
    System.out.println(connectionManager.getConnection());
    System.out.println(connectionManager.getConnection()); // Will return null
    System.out.println(connectionManager.getConnection()); // Will return null
  }
}
