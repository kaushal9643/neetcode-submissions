class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int result[] = new int[n-k+1];

        Deque<Integer> dq = new ArrayDeque<>();


        // add first k element
        for(int i=0; i<k; i++){
            // remove smaller
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        result[0] = nums[dq.peekFirst()];
        for(int i=k; i<n; i++){
            if(dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
            result[i-k+1] = nums[dq.peekFirst()];
        }
        return result;
    }
}
