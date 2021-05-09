package com.test.holding;

import com.test.util.Stack;

public class StackParseExpression {

  private static final Stack<Character> stack = new Stack<Character>();

  static void parse(String string) {
    char[] chars = string.toCharArray();
    for (int i = 0; i < chars.length; ) {
      switch (chars[i++]) {
        case '+': {
          stack.push(chars[i++]);
          break;
        }
        case '-': {
            System.out.println(stack.pop());
        }
      }
    }
  }

  public static void main(String[] args) {
    parse("+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---");
  }
}
