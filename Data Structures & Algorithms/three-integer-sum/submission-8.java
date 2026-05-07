class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lt = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i-1] == nums[i]) continue;
            int left = i+1;
            int right = nums.length-1;

            while(left< right){
                int sum = nums[i] + nums[left]+nums[right];

                if(sum == 0){
                    lt.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return new ArrayList<>(lt);
    }
}
