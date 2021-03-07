package com.test.polymorphism;

class Alert {
  public void getStatus() {}
}

class GreenAlert extends Alert {
  public void getStatus() {
    System.out.println("System is fine!");
  }
}

class YellowAlert extends Alert {
  public void getStatus() {
    System.out.println("System contains some warnings!");
  }
}

class RedAlert extends Alert {
  public void getStatus() {
    System.out.println("SYSTEM IS ON FIRE! FIX IT!");
  }
}

class Incident {
  private Alert alert = new GreenAlert();

  public void overheat() {
    alert = new YellowAlert();
  }

  public void shortCircuit() {
    alert = new RedAlert();
  }

  public void printStatus() {
    alert.getStatus();
  }
}

public class Starship {
  public static void main(String[] args) {
    Incident incident = new Incident();
    incident.printStatus();
    System.out.println("Before overheat");
    incident.overheat();
    incident.printStatus();
    System.out.println("Before short circuit");
    incident.shortCircuit();
    incident.printStatus();
  }
}
