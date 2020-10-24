package com.geek.work4;

/**
 * 买卖股票的最佳时机 II https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BestTimeToBuyAndSellStock2 {

  // 贪心
  public int maxProfitByGreed(int[] prices) {
    int maxprofit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxprofit += prices[i] - prices[i - 1];
      }
    }
    return maxprofit;
  }

  // dp
  public int maxProfitByDp(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }

    int[] dp = new int[prices.length];
    for (int i = 1; i < prices.length; i++) {
      for(int j=0;j<i;j++)
      {
        dp[i]= Math.max(dp[i-1],prices[i]-prices[j]+dp[j]);
      }
    }

    return dp[prices.length-1];
  }
}
