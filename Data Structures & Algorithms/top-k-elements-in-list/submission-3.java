class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+1);
        } 

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)-> freqMap.get(a) - freqMap.get(b));

        for(int num: freqMap.keySet()){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int res[] = new int[k];

        for(int i=0; i<k; i++){
            res[i] = minHeap.poll();
        }

        return res;
    }
}
