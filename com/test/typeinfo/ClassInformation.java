package com.test.typeinfo;

public class ClassInformation {
  public static void printValues(Object[] values) {
    for (Object value : values) {
      System.out.println("  " + value);
    }
  }

  public static void classInfo(Class c) {
    System.out.println("c.getName(): " + c.getName());
    System.out.println("c.getPackage(): " + c.getPackage());
    System.out.println("c.getSuperclass(): " + c.getSuperclass());
    System.out.print("c.getClasses()");
    printValues(c.getClasses());
    System.out.print(c.getInterfaces());
    printValues(c.getInterfaces());
    System.out.print("c.getMethods()");
    printValues(c.getMethods());
    System.out.print("c.getConstructors()");
    printValues(c.getConstructors());
    System.out.print("c.getFields()");
    printValues(c.getFields());
  }

  public static void main(String[] args) throws Exception {
    for (String arg : args) {
      classInfo(Class.forName(arg));
    }
  }
}
