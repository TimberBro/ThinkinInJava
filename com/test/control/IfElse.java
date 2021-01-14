package com.test.control;

public class IfElse {
  public static class Result {
    int match;
    boolean inRange;
  }

  static boolean inRange(int testval, int begin, int end) {
    return testval >= begin && testval <= end;
  }

  static Result test(int testval, int target, int begin, int end) {
    Result i = new Result();
    if (testval > target) {
      i.match = +1;
      i.inRange = inRange(testval, begin, end);
    } else if (testval < target) {
      i.match = -1;
      i.inRange = inRange(testval, begin, end);
    } else {
      i.match = 0; // Match
      i.inRange = inRange(testval, begin, end);
    }
    return i;
  }

  public static void main(String[] args) {
    System.out.println(test(4, 10, 5, 9).match + " " + test(4, 10, 5, 9).inRange);
    /*
    test(5, 10);
    System.out.println(result);
    test(5, 5);
    System.out.println(result);
    */
  }
}
