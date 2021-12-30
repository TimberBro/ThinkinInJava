package com.test.arrays;

import com.test.util.Person;
import java.util.Arrays;

public class NullInitializedArray {
  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(new Person[2][2]));
  }
}
