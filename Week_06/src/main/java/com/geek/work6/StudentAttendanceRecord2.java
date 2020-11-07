package com.geek.work6;

/**
 * 学生出勤记录 II  https://leetcode-cn.com/problems/student-attendance-record-ii/
 */
public class StudentAttendanceRecord2 {

  public int checkRecord(int n) {
    final int mod = 1000000007;
    int[][][] f = new int[n + 1][2][3];

    f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 3; k++) {
          int val = f[i - 1][j][2]; // ...P
          if (j > 0) {
            val = (val + f[i - 1][j - 1][2]) % mod; // ...A
          }

          if (k > 0) {
            val = (val + f[i - 1][j][k - 1]) % mod; // ...L
          }

          f[i][j][k] = val;
        }
      }
    }

    return f[n][1][2];
  }
}
