package com.test.arrays;

import com.test.util.CountingGenerator;
import com.test.util.Generated;
import java.math.BigDecimal;
import java.util.Arrays;

public class BigDecimalGeneration {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            Generated.array(java.math.BigDecimal.class, new CountingGenerator.BigDecimal(), 15)));
  }
}
