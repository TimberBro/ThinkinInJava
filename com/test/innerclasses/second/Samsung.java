package com.test.innerclasses.second;

import com.test.innerclasses.first.Phone;

public class Samsung {

  protected class SamsungPhone implements Phone {

    public SamsungPhone() {}

    @Override
    public String ring() {
      return "Ding!";
    }
  }
}
