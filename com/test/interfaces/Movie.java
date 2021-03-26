package com.test.interfaces;

interface SuperHero {
  void kick();

  void fly();
}

interface Alien {
  void telekinesis();

  void levitate();
}

interface Mutant {
  void roar();

  void scratch();
}

interface Killer extends SuperHero, Alien, Mutant {
  void destroy();
}

abstract class Protagonist {
  void beBad() {}
}

class Thanos extends Protagonist implements Killer {

  @Override
  public void kick() {}

  @Override
  public void fly() {}

  @Override
  public void telekinesis() {}

  @Override
  public void levitate() {}

  @Override
  public void roar() {}

  @Override
  public void scratch() {}

  @Override
  public void destroy() {}
}

public class Movie {
  static void q(SuperHero s) {
    s.fly();
  }

  static void t(Alien a) {
    a.telekinesis();
  }

  static void h(Mutant m) {
    m.scratch();
  }

  static void n(Killer k) {
    k.destroy();
  }

  public static void main(String[] args) {
    Thanos thanos = new Thanos();
    q(thanos);
    t(thanos);
    h(thanos);
    n(thanos);
  }
}
