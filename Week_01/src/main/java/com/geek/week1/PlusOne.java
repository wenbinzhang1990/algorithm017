package com.geek.week1;

import java.util.Stack;

public class PlusOne {

  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i] += 1;
      if ((digits[i] %= 10) != 0) {
        return digits;
      }
    }

    Stack stack=new Stack();

    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }
}
