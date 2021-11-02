package com.test.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class RecoverCADState {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
    // Read in the same order they were written:
    Square.deserializeStaticState(in);
    Circle.deserializeStaticState(in);
    Line.deserializeStaticState(in);
    List<Shape> shapes = (List<Shape>) in.readObject();
    System.out.println(shapes);
  }
}
