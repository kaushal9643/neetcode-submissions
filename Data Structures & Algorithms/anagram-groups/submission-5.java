class Solution {
    public String getFreq(String s){
        int freq[] = new int[26];
        StringBuilder st = new StringBuilder();
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        char c = 'a';
        for(int i=0; i<freq.length; i++){
            st.append(c);
            st.append(freq[i]);
            c++;
        }
        return st.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            String freq = getFreq(s);

            if(map.containsKey(freq)){
                map.get(freq).add(s);
            }else{
                List<String> lt = new ArrayList<>();
                lt.add(s);
                map.put(freq, lt);
            }
        }

        return new ArrayList<>(map.values());
    }
}
