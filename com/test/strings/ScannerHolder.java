package com.test.strings;

import java.util.Locale;
import java.util.Scanner;

public class ScannerHolder {
  int integer;
  long lg;
  float ft;
  double dbl;
  String string;

  ScannerHolder(String str) {
    Scanner scanner = new Scanner(str);
    integer = scanner.nextInt();
    lg = scanner.nextLong();
    ft = scanner.nextFloat();
    dbl = scanner.nextDouble();
    string = scanner.next("\\w+");
  }

  @Override
  public String toString() {
    return "ScannerHolder{"
        + "i="
        + integer
        + ", lg="
        + lg
        + ", ft="
        + ft
        + ", dbl="
        + dbl
        + ", string='"
        + string
        + '\''
        + '}';
  }

  public static void main(String[] args) {
    ScannerHolder holder = new ScannerHolder("100 9223372036854775807 1337,1337 22,22 Hello");
    System.out.println(holder.toString());
  }
}
