package com.test.io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Blip1 implements Externalizable {

  public Blip1() {
    System.out.println("Blip1 Constructor");
  }

  public void writeExternal(ObjectOutput out) throws IOException {
    System.out.println("Blip1.writeExternal");
  }

  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    System.out.println("Blip1.readExternal");
  }
}

public class BlipCheck implements Externalizable {

  public BlipCheck() {
    System.out.println("BlipCheck Constructor");
  }

  public void writeExternal(ObjectOutput out) throws IOException {
    System.out.println("BlipCheck.writeExternal");
  }

  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    System.out.println("BlipCheck.readExternal");
  }
}

class Blips {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    System.out.println("Constructing objects:");
    Blip1 b1 = new Blip1();
    BlipCheck b2 = new BlipCheck();
    ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
    System.out.println("Saving objects:");
    o.writeObject(b1);
    o.writeObject(b2);
    o.close();
    // Now get them back:
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
    System.out.println("Recovering b1:");
    b1 = (Blip1) in.readObject();
    // OOPS! Throws an exception:
    System.out.println("Recovering b2:");
    b2 = (BlipCheck) in.readObject();

    /* Explanation:
    When we remove comments, compiler tries to find non-args public constructor for class BlipCheck.
    There's no valid constructor, so we get: java.io.InvalidClassException: BlipCheck; no valid constructor
    When we comment available constructor compiler able to synthesize constructor by himself, and
    because BlipCheck is public class, it creates public constructor.
     */
    /*
    PS: Exercise text is incorrect. If you copy the file and put it near previous you'll get
    duplicate class error until you delete/comment Blip1 and Blips classes.
    No way you can compile code using steps from exercise text.
     */
  }
}
