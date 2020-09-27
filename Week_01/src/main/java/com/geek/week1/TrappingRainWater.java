package com.geek.week1;

public class TrappingRainWater {

  public int trap(int[] height) {
    int result = 0;
    int maxLeft = 0;
    int maxRight = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= maxLeft) {
          maxLeft = height[left];
        } else {
          result += maxLeft - height[left];
        }

        left++;
      } else {
        if (height[right] >= maxRight) {
          maxRight = height[right];
        } else {
          result += maxRight - height[right];
        }

        right--;
      }
    }

    return result;
  }
}
