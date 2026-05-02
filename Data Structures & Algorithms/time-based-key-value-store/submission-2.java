class TimeMap {
    class pair{
        int timeStamp;
        String value;

        pair(int t, String v){
            timeStamp = t;
            value = v;
        }
    }
    HashMap<String, List<pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            List<pair> lt = new ArrayList<>();
            lt.add(new pair(timestamp, value));
            map.put(key, lt);
        }else{
            map.get(key).add(new pair(timestamp, value));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        int left = 0;
        List<pair> lt = map.get(key);
        int right = lt.size()-1;
        String res = "";
        while(left<=right){
            int mid = left+(right-left)/2;
            if(lt.get(mid).timeStamp <= timestamp){
                res = lt.get(mid).value;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }return res;
    }
}
