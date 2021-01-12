package com.test.control;

public class IfElse2 {
  public static class Result {
    int match;
    boolean inRange;
  }

  static boolean inRange(int testval, int begin, int end) {
    return testval >= begin && testval <= end;
  }

  static Result test(int testval, int target, int begin, int end) {
    Result result = new Result();
    if (testval > target) {
      result.match = 1;
      result.inRange = inRange(testval, begin, end);
      return result;
    } else if (testval < target) {
      result.match = -1;
      result.inRange = inRange(testval, begin, end);
      return result;
    } else {
      result.match = 0;
      result.inRange = inRange(testval, begin, end);
      return result;
    }
  }

  public static void main(String[] args) {
    System.out.println(test(10, 10, 5, 9).match + " " + test(10, 10, 5, 9).inRange);
    /* System.out.println(test(5, 10));
    System.out.println(test(5, 5));
     */
  }
}
