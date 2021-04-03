package com.test.innerclasses;

interface Monster {
  void menace();
}

interface DangerousMonster extends Monster {
  void destroy();
}

interface Lethal {
  void kill();
}

class DragonZilla {

  DangerousMonster getDangerousMonster() {
    return new DangerousMonster() {

      @Override
      public void destroy() {

      }

      @Override
      public void menace() {

      }
    };
  }
  public void menace() {}

  public void destroy() {}
}

interface Vampire extends DangerousMonster, Lethal {
  void drinkBlood();
}

class VeryBadVampire {

  Vampire getVampire() {

    return new Vampire() {
      @Override
      public void drinkBlood() {

      }

      @Override
      public void destroy() {

      }

      @Override
      public void kill() {

      }

      @Override
      public void menace() {

      }
    };
  }
}

public class HorrorShow {
  static void u(Monster b) {
    b.menace();
  }

  static void v(DangerousMonster d) {
    d.menace();
    d.destroy();
  }

  static void w(Lethal l) {
    l.kill();
  }

  public static void main(String[] args) {
    DangerousMonster barney = new DragonZilla().getDangerousMonster();
    u(barney);
    v(barney);
    Vampire vlad = new VeryBadVampire().getVampire();
    u(vlad);
    v(vlad);
    w(vlad);
  }
}
