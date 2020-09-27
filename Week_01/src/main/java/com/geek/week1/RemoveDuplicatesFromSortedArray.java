package com.geek.week1;

public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    removeDuplicates(new int[]{1,1,2,2,4});
  }

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0 || nums == null) {
      return 0;
    }

    int cur = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[cur]) {
        nums[++cur] = nums[i];
      }
    }

    return cur + 1;
  }
}
