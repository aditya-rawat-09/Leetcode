class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int[] freq=new int[26];
        int l=0,r=0,ans=0;
        while(r<n){
            freq[s.charAt(r)-'a']++;
            if(freq[s.charAt(r)-'a']>2){
                while(freq[s.charAt(r)-'a']>2){
                    freq[s.charAt(l)-'a']--;
                    l++;
                }   
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }
    return ans;    
    }
}