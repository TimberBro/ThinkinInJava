package com.test.generics;

import java.util.LinkedHashMap;
import java.util.Map;

class Building {}

class House extends Building {}

public class ClassTypeCapture<T> {
  Map<String, Class<?>> classMap = new LinkedHashMap<>();
  Class<T> kind;

  public ClassTypeCapture(Class<T> kind) {
    this.kind = kind;
  }

  public boolean f(Object arg) {
    return kind.isInstance(arg);
  }

  public void addType(String typename, Class<?> kind) {
    classMap.put(typename, kind);
  }

  public Object createNew(String typename) {
    Class cls = classMap.get(typename);
    try {
      return cls.newInstance();
    } catch (IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
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
    System.out.println(ctt2.createNew("Sloop"));
    ctt2.addType("Sloop", Sloop.class);
    System.out.println(ctt2.createNew("Sloop"));
  }
}
