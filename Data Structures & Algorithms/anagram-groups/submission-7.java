class Solution {
    public String getCode(String str){
        int freq[] = new int[26];
        StringBuilder s = new StringBuilder();

        for(int i=0; i<str.length(); i++){
            freq[str.charAt(i)-'a']++;
        }

        char c = 'a';
        for(int i=0; i<freq.length; i++){
            s.append(c++);
            s.append(freq[i]);
        }

        return s.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String code = getCode(strs[i]);

            if(map.containsKey(code)){
                map.get(code).add(strs[i]);
            }else{
                List<String> st = new ArrayList<>();
                st.add(strs[i]);
                map.put(code, st);
            }
        }

        return new ArrayList<>(map.values());
    }
}
