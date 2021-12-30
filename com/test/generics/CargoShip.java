package com.test.generics;

import com.test.util.Generator;
import java.util.ArrayList;
import java.util.Random;

class Container {
  private final int id;
  private String description;
  private double price;

  public Container(int IDnumber, String descr, double price) {
    id = IDnumber;
    description = descr;
    this.price = price;
    System.out.println(toString());
  }

  public String toString() {
    return id + ": " + description + ", price: $" + price;
  }

  public void priceChange(double change) {
    price += change;
  }

  public static Generator<Container> generator =
      new Generator<Container>() {
        private Random rand = new Random(47);

        public Container next() {
          return new Container(
              rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }
      };
}

class Warehouse extends ArrayList<Container> {
  public Warehouse(int nContainers) {
    Generators.fill(this, Container.generator, nContainers);
  }
}

class Column extends ArrayList<Warehouse> {
  public Column(int nShelves, int nContainers) {
    for (int i = 0; i < nShelves; i++) {
      add(new Warehouse(nContainers));
    }
  }
}

class Crane {}

class Port {}

public class CargoShip extends ArrayList<Column> {
  private ArrayList<Crane> cranes = new ArrayList<Crane>();
  private Port Port = new Port();

  public CargoShip(int nColumns, int nWarehouses, int nContainers) {
    for (int i = 0; i < nColumns; i++) {
      add(new Column(nWarehouses, nContainers));
    }
  }

  public String toString() {
    StringBuilder result = new StringBuilder();
    for (Column a : this) {
      for (Warehouse s : a) {
        for (Container p : s) {
          result.append(p);
          result.append("\n");
        }
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(new CargoShip(14, 5, 10));
  }
}
