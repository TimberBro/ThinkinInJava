package com.test.arrays;

import com.test.util.ConvertTo;
import com.test.util.CountingGenerator;
import com.test.util.Generated;
import java.util.Arrays;

public class ArrayOfDouble {
  public static void main(String[] args) {
    double[] doubles =
        ConvertTo.primitive(Generated.array(Double.class, new CountingGenerator.Double(), 15));
    System.out.println(Arrays.toString(doubles));
  }
}
