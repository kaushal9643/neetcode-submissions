class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left+(right-left)/2;

            if(nums[mid] == target) return mid;
            // Check for sorted half
            if(nums[mid] >= nums[left]){
                // left half is sorted
                if(nums[left] <= target && nums[mid] > target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            else{
                // right part is sorted
                if(nums[mid] < target && nums[right] >= target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
