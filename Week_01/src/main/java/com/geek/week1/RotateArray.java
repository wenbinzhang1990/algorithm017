package com.geek.week1;

public class RotateArray {
  public static void main(String[] args) {
    rotate(new int[]{1,1,2,2,4},3);
  }

  public static void rotate(int[] nums, int k) {
    k%=nums.length;
    reverse(nums,0,nums.length-1);
    reverse(nums,0,k-1);
    reverse(nums,k,nums.length-1);
  }

  public static void reverse(int[] nums,int begin,int end)
  {
    while(begin<end)
    {
      int temp=nums[begin];
      nums[begin]=nums[end];
      nums[end]=temp;
      begin++;
      end--;
    }
  }
}
