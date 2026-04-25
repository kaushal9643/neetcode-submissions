class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int result[] = new int[n-k+1];

        // Set up dequeue for the first k elements
        for(int i=0; i<k; i++){
            // remove all smaller elements from the back
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        // the front of dequeue is the max of first window
        result[0] = nums[dq.peekFirst()];

        // process remaining
        for(int i=k; i<n; i++){
            // remove the element that has slid out of the dequeue
            if(dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            // Remove all elements smaller than the incoming element
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            // Add current element index
            dq.offerLast(i);

            // the front of the dequeue is always the max
            result[i-k+1] = nums[dq.peekFirst()];
        }
        return result;
    }
}
