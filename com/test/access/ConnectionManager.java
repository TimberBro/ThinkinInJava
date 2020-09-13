package com.test.access;

class ConnectionManager {
    static int MaxConnections = 2;
    static int CurrentConnections = 0;
    private ConnectionManager(){
        System.out.println("Connection created");
        CurrentConnections++;
    }
    public static ConnectionManager CreateConnection(){
        if (CurrentConnections < MaxConnections) {
            return new ConnectionManager();
        }
        else return null;
    }
    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            CreateConnection();
        }
    }
}
