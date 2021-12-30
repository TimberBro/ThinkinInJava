package com.test.typeinfo;

import com.test.typeinfo.packageaccess.A;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExecutingProtectedMethods {
  public static void main(String[] args) {
    A a = new A();
    Method[] methods = a.getClass().getDeclaredMethods();
    for (Method method : methods) {
      method.setAccessible(true);
      try {
        method.invoke(a);
      } catch (IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
      }
    }
  }
}
