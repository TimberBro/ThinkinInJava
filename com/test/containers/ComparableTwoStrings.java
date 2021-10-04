package com.test.containers;

public class ComparableTwoStrings implements Comparable<ComparableTwoStrings> {

  private String firstString;
  private String secondString;

  public String getFirstString() {
    return firstString;
  }

  public String getSecondString() {
    return secondString;
  }

  public void setFirstString(String firstString) {
    this.firstString = firstString;
  }

  public void setSecondString(String secondString) {
    this.secondString = secondString;
  }

  public ComparableTwoStrings(String firstString, String secondString) {
    this.firstString = firstString;
    this.secondString = secondString;
  }

  @Override
  public int compareTo(ComparableTwoStrings str) {
    return firstString.compareTo(str.getFirstString());
  }

  @Override
  public String toString() {
    return "ComparableTwoStrings{" + "firstString='" + firstString + '\'' + ", secondString='"
        + secondString + '\'' + '}';
  }
}
