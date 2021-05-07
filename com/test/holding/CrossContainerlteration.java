package com.test.holding;

import java.util.*;




public class CrossContainerlteration {
  public static void display(Iterator<String> iterator) {
    while (iterator.hasNext()) {
      System.out.println(iterator.next().toString());
    }
  }


  public static void main(String[] args) {
    ArrayList<String> nameAL = new ArrayList<String>();
    LinkedList<String> nameLL = new LinkedList<String>();
    HashSet<String> nameHS = new HashSet<String>();
    TreeSet<String> nameTS = new TreeSet<String>();
    LinkedHashSet<String> nameLHS = new LinkedHashSet<String>();
    StarWarsNamesCollectionFiller.fill(nameAL);
    StarWarsNamesCollectionFiller.fill(nameLL);
    StarWarsNamesCollectionFiller.fill(nameHS);
    StarWarsNamesCollectionFiller.fill(nameTS);
    StarWarsNamesCollectionFiller.fill(nameLHS);
    display(nameAL.iterator());
    display(nameLL.iterator());
    display(nameHS.iterator());
    display(nameTS.iterator());
    display(nameLHS.iterator());
  }
}
