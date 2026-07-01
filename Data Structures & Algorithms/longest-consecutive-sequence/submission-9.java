class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();

        for(int num: nums){
            st.add(num);
        }

        int maxCount = 0;
        
        for(int i=0; i<nums.length; i++){
            int currNum = nums[i];
            int currCount = 0;

            if(!st.contains(currNum-1)){
                currCount = 1;
                while(st.contains(currNum+1)){
                    currCount++;
                    currNum++;
                }
            }
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }
}
