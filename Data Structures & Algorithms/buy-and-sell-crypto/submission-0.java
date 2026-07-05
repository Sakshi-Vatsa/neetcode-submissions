class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0) return 0;
        int min_till_now=prices[0], profit=0;
        for(int i=1;i<n;i++) {
            if(prices[i]<min_till_now) {
                min_till_now = prices[i];
            } else {
                profit = Math.max(profit, prices[i]-min_till_now);
            }
        }
        return profit;
    }
}
 