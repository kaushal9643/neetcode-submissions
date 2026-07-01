class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for(String st: strs){
            s.append(st.length())
            .append('#')
            .append(st);
        }
        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> st = new ArrayList<>();

        int i=0;
        while(i < str.length()){
            int j=i;

            while(str.charAt(j) != '#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));
            j++;
            String s = str.substring(j, j+len);
            st.add(s);

            i=j+len;
        }
        return st;
    }
}
