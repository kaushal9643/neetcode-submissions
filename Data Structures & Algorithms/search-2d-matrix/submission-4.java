class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        int n = nums.length;
        int m = nums[0].length;

        int left = 0;
        int right = n*m-1;

        while(left <= right){
            int mid = left+(right-left);

            if(nums[mid/m][mid%m] == target){
                return true;
            }
            else if(nums[mid/m][mid%m] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }   
        return false;
    }
}
