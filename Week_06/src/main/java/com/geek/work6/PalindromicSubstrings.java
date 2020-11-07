package com.geek.work6;

/**
 * 回文字串 https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {

  public int countSubstrings(String s) {
    if (s.length() == 0) {
      return 0;
    }

    int result = 0;
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int j = 0; j < s.length(); j++) {
      for (int i = 0; i <= j; i++) {
        if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
          dp[i][j] = true;
          result++;
        }
      }
    }

    return result;
  }
}
