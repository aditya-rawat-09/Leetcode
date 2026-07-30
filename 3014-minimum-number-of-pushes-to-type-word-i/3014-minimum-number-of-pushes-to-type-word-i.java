class Solution {
    public int minimumPushes(String word) {
        int ans=0;
        int n=word.length();
        if(n<=8)return n;
        else if(n<=16) return (n-8)*2+8;
        else if(n<=24)return ((n-16)*3)+24;
        else if(n<=26)return ((n-24)*4)+48;
        return 0;
        
    }
}