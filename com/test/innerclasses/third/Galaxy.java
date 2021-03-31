package com.test.innerclasses.third;

import com.test.innerclasses.first.Phone;
import com.test.innerclasses.second.Samsung;

public class Galaxy extends Samsung {

  Phone createSamsungGalaxyPhone() {
    return this.new SamsungPhone();
  }

  public static void main(String[] args) {
    Galaxy galaxy = new Galaxy();
    System.out.println(galaxy.createSamsungGalaxyPhone().ring());
  }
}
