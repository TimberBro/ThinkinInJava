package com.test.typeinfo.factory;

import com.test.util.Null;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NullPartProxyHandler implements InvocationHandler {

  private String nullName;
  private Part proxied = new NullPart();

  NullPartProxyHandler(Class<? extends Part> type) {
    nullName = type.getSimpleName() + " NullPart";
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return method.invoke(proxied, args);
  }

  private class NullPart implements Null, Part {

    @Override
    public String toString() {
      return nullName;
    }
  }
}
