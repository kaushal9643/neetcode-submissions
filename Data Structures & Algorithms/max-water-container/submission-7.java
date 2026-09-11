class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;

        int maxWater = 0;
        while(left < right){
            int water = Integer.min(heights[left], heights[right]) * (right-left);

            if(heights[left] > heights[right]){
                right--;
            }else{
                left++;
            }

            maxWater = Integer.max(maxWater, water);
        }
        return maxWater;
    }
}
