package com.test.typeinfo.factory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Part {
  public String toString() {
    return getClass().getSimpleName();
  }

  @SuppressWarnings("unchecked")
  public static final List<Class<? extends Part>> allParts =
      Collections.unmodifiableList(
          Arrays.asList(
              AirFilter.class,
              Belt.class,
              CabinAirFilter.class,
              FanBelt.class,
              Filter.class,
              FuelFilter.class,
              GeneratorBelt.class,
              OilFilter.class,
              PowerSteeringBelt.class));

  private static Random rand = new Random(47);

  public static Part createRandom() {
    int n = rand.nextInt(allParts.size());
    try {
      return allParts.get(n).newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
}
