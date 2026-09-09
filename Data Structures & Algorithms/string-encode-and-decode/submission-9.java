class Solution {

    public String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();
        for(String s: strs){
            st.append(s.length());
            st.append('#');
            st.append(s);
        }

        return st.toString();
    }

    public List<String> decode(String str) {
        int right = 0;
        ArrayList<String> lt = new ArrayList<>();

        while(right < str.length()){
            int left = right;

            while(str.charAt(left) != '#'){
                left++;
            }
            int len = Integer.parseInt(str.substring(right, left));

            left++;

            String s = str.substring(left, left+len);
            lt.add(s);
            right = left+len;
        }
        return lt;
    }
}
