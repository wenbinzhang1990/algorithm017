package com.geek.work7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N皇后 https://leetcode-cn.com/problems/n-queens/
 */
public class NQueensByIteration {


  int[][] queueArray;
  List<List<String>> result = new ArrayList<>();
  int max = 0;
  Set<Integer> colMap = new HashSet<>();
  Set<Integer> leftLine = new HashSet<>();
  Set<Integer> rightLine = new HashSet<>();

  public List<List<String>> solveNQueens(int n) {
    if (n <= 0 || n == 2) {
      return new ArrayList<>();
    }

    queueArray=new int[n][n];
    max = n;
    dfs(0);
    return result;
  }

  private void dfs(int row) {
    if (row == max) {
      finish(queueArray);
      return;
    }

    for (int i = 0; i < max; i++) {
      if (allowed(row, i)) {
        addFlag(row, i);
        dfs(row + 1);
        removeFlag(row, i);
      }
    }
  }

  private boolean allowed(int row, int col) {
    if (colMap.contains(col) || leftLine.contains(row + col) || rightLine.contains(col - row)) {
      return false;
    }

    return true;
  }

  private void addFlag(int row, int col) {
    queueArray[row][col] = 1;
    colMap.add(col);
    leftLine.add(row + col);
    rightLine.add(col - row);

  }

  private void removeFlag(int row, int col) {
    queueArray[row][col] = 0;
    colMap.remove(col);
    leftLine.remove(row + col);
    rightLine.remove(col - row);
  }

  private void finish(int[][] num) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < num.length; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < num[0].length; j++) {
        sb.append(num[i][j] == 1 ? "Q" : ".");
      }

      list.add(sb.toString());
    }

    result.add(list);
  }
}
