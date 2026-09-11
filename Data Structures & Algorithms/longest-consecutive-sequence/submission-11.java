class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            st.add(nums[i]);
        }
        int max = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            if(!st.contains(curr-1)){
                count = 1;
                while(st.contains(curr+1)){
                    curr++;
                    count++;
                }
            }
            max = Integer.max(max, count);
        }
        return max;
    }
}
