class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;

        int maxWater = 0;
        while(left < right){
            int minHeight = Math.min(heights[left], heights[right]);
            int currWater = minHeight * (right-left);

            maxWater = Math.max(maxWater, currWater);

            if(heights[left] > heights[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxWater;
    }
}
