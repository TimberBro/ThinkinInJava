package com.test.arrays;

public class BerylliumSphereCounter {
  static void count(BerylliumSphere[] spheres) {
    System.out.println("Number of spheres = " + spheres.length);
  }

  public static void main(String[] args) {
    count(
        new BerylliumSphere[] {
          new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()
        });
    BerylliumSphere[] spheres1 = {
      new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()
    };
    count(spheres1);
    BerylliumSphere[] spheres2 =
        new BerylliumSphere[] {new BerylliumSphere(), new BerylliumSphere()};
    count(spheres2);
    /*
    1) I don't understand what is "ordinary aggregate array initialization"
    and why it shouldn't work. Google doesn't know about this term.
    2) I couldn't find where dynamic aggregate initialization is redundant.
     */
  }
}
