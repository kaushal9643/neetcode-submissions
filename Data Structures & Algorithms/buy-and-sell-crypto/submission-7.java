class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int maxProfit = 0;
        for(int right = 1; right<prices.length; right++){
            int currProfit = prices[right]-prices[left];
            if(currProfit < 0){
                left = right;
            }
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;
    }
}
