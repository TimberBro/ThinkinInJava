package com.test.typeinfo.factory;

import com.test.util.Null;
import java.lang.reflect.Array;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class PartImpl implements Part {

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

  public static Part nullPart(Class<? extends Part> type) {
    return (Part) Proxy.newProxyInstance(Part.class.getClassLoader(),
        new Class[] {Null.class, Part.class},
        new NullPartProxyHandler(type));
  }

  static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();

  static {
    partFactories.add(new FuelFilter.Factory());
    partFactories.add(new AirFilter.Factory());
    partFactories.add(new CabinAirFilter.Factory());
    partFactories.add(new OilFilter.Factory());
    partFactories.add(new FanBelt.Factory());
    partFactories.add(new PowerSteeringBelt.Factory());
    partFactories.add(new GeneratorBelt.Factory());
  }
}
