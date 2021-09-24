package com.test.containers;

import com.test.util.Countries;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Exercise7 {

  public static void main(String[] args) {
    ArrayList<String> arrayList = new ArrayList<>(Countries.names(10));
    LinkedList<String> linkedList = new LinkedList<>(Countries.names(20).subList(10, 20));

    System.out.println("Print ArrayList using ordinary Iterator.");
    Iterator<String> arrayIterator = arrayList.iterator();
    while (arrayIterator.hasNext()) {
      System.out.print(arrayIterator.next() + ", ");
    }

    System.out.println("\nPrint LinkedList using ordinary Iterator.");
    Iterator<String> linkedIterator = linkedList.listIterator();
    while (linkedIterator.hasNext()) {
      System.out.print(linkedIterator.next() + ", ");
    }

    ListIterator<String> arrayListIterator = arrayList.listIterator();
    ListIterator<String> linkedListIterator = linkedList.listIterator();

    // As I understand every other means through 2 elements.
    int linkedListIndex = 0;
    while (arrayListIterator.hasNext()) {
      linkedList.add(linkedListIndex, arrayListIterator.next());
      linkedListIndex += 2;
    }
    System.out.println("\nElements inserted at every other location.");
    for (String s : linkedList) {
      System.out.print(s + ", ");
    }

    linkedListIndex = 0;
    arrayListIterator = arrayList.listIterator(arrayList.size());
    while (arrayListIterator.hasPrevious()) {
      linkedList.add(linkedListIndex, arrayListIterator.previous());
      linkedListIndex += 2;
    }

    System.out.println("\nElements inserted at every other location backwardly from ArrayList.");
    for (String s : linkedList) {
      System.out.print(s + ", ");
    }
    System.out.println(linkedList.size());
  }
}
