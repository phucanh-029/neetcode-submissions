class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        int res = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]<dp[i-1]){
                dp[i] = prices[i];
            }
            else{
                dp[i] = dp[i-1];
            }
            res = Math.max(prices[i]-dp[i],res);
        }
        return res;
    }
}
