package com.test.strings;

import java.util.Formatter;

public class Receipt {
  final int itemWidth = 15;
  final int quantityWidth = 5;
  final int priceWidth = 10;

  private double total = 0;
  private Formatter f = new Formatter(System.out);

  public void printTitle() {
    f.format("%-" + itemWidth + "s %" + quantityWidth + "s %" + priceWidth + "s\n", "Item", "Qty",
        "Price");
    f.format("%-" + itemWidth + "s %" + quantityWidth + "s %" + priceWidth + "s\n", " ", "---",
        " ");
  }

  public void print(String name, int qty, double price) {
    f.format("%-" + itemWidth + ".15s %" + quantityWidth + "d %" + priceWidth + ".2f\n", name, qty,
        price);
    total += price;
  }

  public void printTotal() {
    f.format("%-" + itemWidth + "s %" + quantityWidth + "s %" + priceWidth + ".2f\n", "Tax", "",
        total * 0.06);
    f.format("%-" + itemWidth + "s %" + quantityWidth + "s %" + priceWidth + "s\n", "", "", " ");
    f.format("%-" + itemWidth + "s %" + quantityWidth + "s %" + priceWidth + ".2f\n", "Total", "",
        total * 1.06);
  }

  public static void main(String[] args) {
    Receipt receipt = new Receipt();
    receipt.printTitle();
    receipt.print("Jack' s Magic Beans", 4, 4.25);
    receipt.print("Princess Peas", 3, 5.1);
    receipt.print("Three Bears Porridge", 1, 14.29);
    receipt.printTotal();
  }
}
