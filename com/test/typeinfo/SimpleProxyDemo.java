package com.test.typeinfo;

interface Interface {
  void doSomething();

  void somethingElse(String arg);
}

class RealObject implements Interface {
  public void doSomething() {
    System.out.println("doSomething");
  }

  public void somethingElse(String arg) {
    System.out.println("somethingElse " + arg);
  }
}

class SimpleProxy implements Interface {
  private Interface proxied;

  public SimpleProxy(Interface proxied) {
    this.proxied = proxied;
  }

  public void doSomething() {
    System.out.println("SimpleProxy doSomething");
    long start = System.currentTimeMillis();
    proxied.doSomething();
    try {
      Thread.sleep(150);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(
        "Execution time = " + (System.currentTimeMillis() - start) + " milliseconds");
  }

  public void somethingElse(String arg) {
    System.out.println("SimpleProxy somethingElse " + arg);
    long start = System.currentTimeMillis();
    proxied.somethingElse(arg);
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(
        "Execution time = " + (System.currentTimeMillis() - start) + " milliseconds");
  }
}

public class SimpleProxyDemo {
  public static void consumer(Interface iface) {
    iface.doSomething();
    iface.somethingElse("bonobo");
  }

  public static void main(String[] args) {
    consumer(new RealObject());
    consumer(new SimpleProxy(new RealObject()));
  }
}
