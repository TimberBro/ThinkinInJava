package com.test.generics;

import java.util.LinkedHashMap;
import java.util.Map;

class Building {}

class House extends Building {}

public class ClassTypeCapture<T> {
  Map<String, FactoryI<?>> classMap = new LinkedHashMap<>();
  Class<T> kind;

  public ClassTypeCapture(Class<T> kind) {
    this.kind = kind;
  }

  public boolean f(Object arg) {
    return kind.isInstance(arg);
  }

  public void addType(String typename, FactoryI<?> factory) {
    classMap.put(typename, factory);
  }

  public Object createNew(String factoryName, int i) {
    FactoryI<?> factory = classMap.get(factoryName);
    try {
      return factory.create(i);
    } catch (NullPointerException e) {
      System.out.println(
          "Cannot produce object of this type. "
              + "The class representing this type has not been added to the type list.");
    }
    return null;
  }

  public static void main(String[] args) {
    ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
    System.out.println(ctt1.f(new Building()));
    System.out.println(ctt1.f(new House()));
    ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
    System.out.println(ctt2.f(new Building()));
    System.out.println(ctt2.f(new House()));
    System.out.println(ctt2.createNew("Integer", 1));
    ctt2.addType("Integer", new IntegerFactory());
    System.out.println(ctt2.createNew("Integer", 1));
  }
}
