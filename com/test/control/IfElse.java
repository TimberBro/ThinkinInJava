package com.test.control;


public class IfElse {
  public static class Result {
    int match;
    boolean inRange;
  }

  static Result test(int testval, int target, int begin, int end) {
    Result i = new Result();
    if (testval > target) {
      if (testval >= begin && testval <= end) {
        i.match = +1;
        i.inRange = true;
      } else {
        i.match = +1;
        i.inRange = false;
      }
    } else if (testval < target) {
      if (testval >= begin && testval <= end) {
        i.match = -1;
        i.inRange = true;
      } else {
        i.match = -1;
        i.inRange = false;
      }
    } else {
      i.match = 0; // Match
      i.inRange = true;
    }
    return i;
  }

  public static void main(String[] args) {
    System.out.println(test(10, 5, 1, 11).match + " " + test(10, 5, 1, 11).inRange);
    /*
    test(5, 10);
    System.out.println(result);
    test(5, 5);
    System.out.println(result);
    */
  }
}
