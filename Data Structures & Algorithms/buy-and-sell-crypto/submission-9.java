class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int max = 0;
        for(int right=1; right<prices.length; right++){
            int profit =  prices[right] - prices[left];
            if(profit < 0){
                left = right;
            }
            max = Math.max(profit, max);
        }
        return max;
    }
}
