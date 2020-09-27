package com.geek.week1;

import java.util.Arrays;

public class MergeSortedArray {

  public static void main(String[] args) {
    int[] nums1 = new int[]{0};
    int[] nums2 = new int[]{1};
    merge(nums1,0,nums2,1);
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int tail = m + n - 1;
    int len1 = m - 1;
    int len2 = n - 1;
    while (len1 >= 0 && len2 >= 0) {
      nums1[tail--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
    }

    if (len2 >= 0) {
      System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }
  }
}
