package com.geek.work4;

/**
 * 跳跃游戏 https://leetcode-cn.com/problems/jump-game/
 */
public class JumpGame {


  public boolean canJump(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return true;
    }

    int max = 0;
    for (int i = 0; i < nums.length ; i++) {
      if (max < i) {
        return false;
      }

      max = Math.max(max, i + nums[i]);
    }

    return true;
  }
}
