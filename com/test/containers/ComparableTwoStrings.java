package com.test.containers;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComparableTwoStrings that = (ComparableTwoStrings) o;
    return getFirstString().equals(that.getFirstString()) && getSecondString()
        .equals(that.getSecondString());
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = result * 37 + firstString.hashCode();
    result = result * 37 + secondString.hashCode();
    return result;
  }
}
