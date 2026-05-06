class Solution {

    public String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();
        for(String s: strs){
            st.append(s.length())
                .append("#")
                    .append(s);
        }
        return st.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        List<String> lt = new ArrayList<>();

        while(i < str.length()){
            int j=i;

            while(str.charAt(j) != '#'){
                j++;
            }

            int strLen = Integer.parseInt(str.substring(i, j));

            // Skip "#"
            j++;

            String s = str.substring(j, j+strLen);
            lt.add(s);

            i=j+strLen;
        }
        return lt;
    }
}
