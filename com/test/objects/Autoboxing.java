package com.test.objects;

public class Autoboxing {
  // Задаю переменные типа объектов-обертков и присваиваю им значение примитивов.
  // Для присваивания используется автобоксинг примитива для присваивания его значения объекту.
  Boolean b = true;
  Character c = 'a';
  Byte be = 22;
  Short st = 287;
  Integer itg = 2147;
  Long lg = 922337203685477580L;
  Float ft = 43.2f;
  Double db = 42.3;
  // Задаю переменные типа примитив и присваиваю им значения объектов-оберток.
  // Для присваивания используется анбоксинг объекта для присваивания его значения примитиву.
  boolean bool = b;
  char ch = c;
  byte by = be;
  short sh = st;
  int i = itg;
  long lng = lg;
  float flt = ft;
  double dbl = db;

  public static void main(String[] args) {
    Autoboxing autoboxing = new Autoboxing();
    System.out.println(autoboxing.bool);
    System.out.println(autoboxing.ch);
    System.out.println(autoboxing.by);
    System.out.println(autoboxing.sh);
    System.out.println(autoboxing.i);
    System.out.println(autoboxing.lng);
    System.out.println(autoboxing.flt);
    System.out.println(autoboxing.dbl);
  }
}
