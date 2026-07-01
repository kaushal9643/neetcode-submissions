class Solution {
    public String getFreq(String s){
        int freq[] = new int[26];

        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }

        char c = 'a';
        StringBuilder st = new StringBuilder();
        for(int i=0; i<freq.length; i++){
            st.append(c++);
            st.append(freq[i]);
        }

        return st.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String strFreq = getFreq(strs[i]);

            if(map.containsKey(strFreq)){
                map.get(strFreq).add(strs[i]);
            }else{
                ArrayList<String> lt = new ArrayList<>();
                lt.add(strs[i]);
                map.put(strFreq, lt);
            }
        }

        return new ArrayList<>(map.values());
    }
}
