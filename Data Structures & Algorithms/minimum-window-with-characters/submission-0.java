class Solution {
    public boolean contains(int maps[], int mapt[]){
        for(int i=0; i<128; i++){
            if(mapt[i] > maps[i]){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int maps[] = new int[128];
        int mapt[] = new int[128];

        for(char c: t.toCharArray()){
            mapt[c]++;
        }

        int left = 0, minLen = Integer.MAX_VALUE, minStart = 0;

        for(int right=0; right<s.length(); right++){
            maps[s.charAt(right)]++; 

            while(contains(maps, mapt)){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    minStart = left;
                }
                maps[s.charAt(left)]--;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
    }
}
