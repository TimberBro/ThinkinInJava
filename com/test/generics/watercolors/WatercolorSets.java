package com.test.generics.watercolors;

import static com.test.generics.watercolors.Watercolors.*;
import static com.test.util.Sets.complement;
import static com.test.util.Sets.difference;
import static com.test.util.Sets.intersection;
import static com.test.util.Sets.union;

import com.test.util.Sets;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class WatercolorSets {
  public static void main(String[] args) {
    Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
    Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
    System.out.println("set1: " + set1);
    System.out.println("set2: " + set2);
    System.out.println("union(set1, set2): " + union(set1, set2));
    Set<Watercolors> subset = intersection(set1, set2);
    System.out.println("intersection(set1, set2) : " + subset);
    System.out.println("difference(set1, subset): " + difference(set1, subset));
    System.out.println("difference(set2, subset): " + difference(set2, subset));
    System.out.println("complement(set1, set2): " + complement(set1, set2));
    // Check result type of union operation
    System.out.println(
        "union(set1, set2) type: " + Sets.union(set1, set2).getClass().getSimpleName());
    Set<Integer> set3 = new HashSet<>();
    Set<Integer> set4 = new HashSet<>();
    set3.add(15);
    set4.add(18);
    System.out.println(
        "union(set3, set4) type: " + Sets.union(set3, set4).getClass().getSimpleName());
  }
}
