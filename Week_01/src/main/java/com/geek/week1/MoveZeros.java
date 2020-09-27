package com.geek.week1;

public class MoveZeros {

  public void moveZeroes(int[] nums) {
    if (nums == null) {
      return;
    }

    int cur = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[cur] = nums[i];
        if (i > cur) {
          nums[i] = 0;
        }

        cur++;
      }
    }
  }
}
