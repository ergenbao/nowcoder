/**
 * 买卖股票的最好时机
 */
public class MaxProfit {
  /**
   * 思路：使用贪心算法的思想来解决问题
   * 定义一个值用于存储当前的最小值。
   * 遍历数组，如果当前值小于最小值，则更新。
   * 当前值卖出的最大利润为 ： 当前值 - 当前的最小值
   */
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int minVal = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < minVal){
        minVal = prices[i];
      }
      maxProfit = Math.max(maxProfit,prices[i] - minVal);
    }
    return maxProfit;
  }
}
