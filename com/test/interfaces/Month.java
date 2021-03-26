package com.test.interfaces;

interface Days {
  int MONDAY = 1, TUESDAY = 2, WEDNESDAY = 3,
      THURSDAY = 4, FRIDAY = 5, SATURDAY = 6, SUNDAY = 7;
}

class Week implements Days {

}

public class Month {
  public static void main(String[] args) {
    System.out.println("Monday = " + Days.MONDAY);
    // Days available without any object created. Then Days is static.
    Week week1 = new Week();
    // week1.MONDAY = 3; // Cannot assign a value to final variable 'MONDAY'
  }
}
