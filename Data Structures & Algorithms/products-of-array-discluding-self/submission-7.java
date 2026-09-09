class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];

        res[0] = 1;
        for(int i=1; i<res.length; i++){
            res[i] = nums[i-1]*res[i-1];
        }

        int suffix = 1;
        for(int right = res.length-1; right>=0; right--){
            res[right] = res[right]*suffix;
            suffix = nums[right]*suffix;
        }
        return res;
    }
}  
