class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();

        int[] freq=new int[26];
        for(int i=0;i<n;i=i+1){
            freq[s.charAt(i)-'a']++;
        }

        StringBuilder ans=new StringBuilder();
        char middle=0;
        for(int i=0;i<26;i+=1){
            for(int j=0;j<freq[i]/2;j+=1){
                ans.append((char)('a'+i));
            }
                if ((freq[i] & 1) == 1) {
                middle = (char) ('a' + i);
            }
        }
        StringBuilder rev=new StringBuilder(ans).reverse();
        if(middle!=0) ans.append(middle);
        ans.append(rev);
        return ans.toString();
        
    }
}