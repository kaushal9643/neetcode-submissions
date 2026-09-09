class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));

        for(int val: map.keySet()){
            pq.add(val);
            if(pq.size()>k){
                pq.remove();
            }
        }

        int res[] = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.remove();
        }

        return res;
    }
}
