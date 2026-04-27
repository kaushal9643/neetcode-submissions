class Solution {
    public String getFreq(String str){
        int freq[] = new int[26];
        for(char c: str.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder s = new StringBuilder("");
        char c = 'a';
        for(int i: freq){
            s.append(c);
            s.append(i);
            c++;
        }
        return s.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            String freq = getFreq(str);

            if(map.containsKey(freq)){
                map.get(freq).add(str);
            }else{
                List<String> lt = new ArrayList<>();
                lt.add(str);
                map.put(freq, lt);
            }
        }
        return new ArrayList<>(map.values());
    }
}
