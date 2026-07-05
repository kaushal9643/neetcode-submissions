class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Set<Character> st = new HashSet<>();
        for(int right = 0; right<s.length(); right++){
            while(st.contains(s.charAt(right))){
                st.remove(s.charAt(left));
                left++;
            }
            st.add(s.charAt(right));
            int count = (right-left)+1;
            max = Math.max(max, count);
        }
        return max;
    }
}
