package com.test.arrays;

import com.test.util.ConvertTo;
import com.test.util.CountingGenerator;
import com.test.util.Generated;
import java.util.Arrays;

public class PrimitiveArrays {
  public static void main(String[] args) {
    byte[] bytes =
        ConvertTo.primitive(Generated.array(Byte.class, new CountingGenerator.Byte(), 15));
    System.out.println("byte[]: " + Arrays.toString(bytes));
    short[] shorts =
        ConvertTo.primitive(Generated.array(Short.class, new CountingGenerator.Short(), 15));
    System.out.println("short[]: " + Arrays.toString(shorts));
    int[] ints =
        ConvertTo.primitive(Generated.array(Integer.class, new CountingGenerator.Integer(), 15));
    System.out.println("int[]: " + Arrays.toString(ints));
    long[] longs =
        ConvertTo.primitive(Generated.array(Long.class, new CountingGenerator.Long(), 15));
    System.out.println("long[]: " + Arrays.toString(longs));
    float[] floats =
        ConvertTo.primitive(Generated.array(Float.class, new CountingGenerator.Float(), 15));
    System.out.println("float[]: " + Arrays.toString(floats));
    double[] doubles =
        ConvertTo.primitive(Generated.array(Double.class, new CountingGenerator.Double(), 15));
    System.out.println("double[]: " + Arrays.toString(doubles));
    char[] chars =
        ConvertTo.primitive(
            Generated.array(Character.class, new CountingGenerator.Character(), 15));
    System.out.println("char[]: " + Arrays.toString(chars));
    String[] strings = (Generated.array(String.class, new CountingGenerator.String(), 15));
    System.out.println("String[]: " + Arrays.toString(strings));
    boolean[] booleans =
        ConvertTo.primitive(Generated.array(Boolean.class, new CountingGenerator.Boolean(), 15));
    System.out.println("boolean[]: " + Arrays.toString(booleans));
  }
}
