class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        int maxLength = 0;

        for(int num: set){
            if(!set.contains(num-1)){
                int count = 1;
                int currNum = num;
                while(set.contains(currNum+1)){
                    count++;
                    currNum++;
                }
            maxLength = Math.max(count, maxLength);
            }
        }
        return maxLength;
    }
}
