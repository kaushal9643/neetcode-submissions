class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;

        int maxWater = 0;

        while(left < right){
            int max = Math.min(heights[left], heights[right]);
            int currWater = (right-left) * max;

            if(heights[left] > heights[right]){
                right--;
            }else{
                left++;
            }
            maxWater = Math.max(currWater, maxWater);
        }
        return maxWater;
    }
}
