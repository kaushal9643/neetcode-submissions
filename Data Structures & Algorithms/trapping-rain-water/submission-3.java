class Solution {
    public int trap(int[] height) {
        
        // left max
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i=1; i<height.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        // right max
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int water = 0;
        for(int i=0; i<height.length; i++){
            water += Math.min(leftMax[i], rightMax[i])-height[i];
        }
        return water;
    }
}
