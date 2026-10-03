class Solution {
    public int longestValidParentheses(String s) {
        int open=0,close=0,ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') open++;
            else close++;

            if(open==close)ans=Math.max(ans,open*2);
            else if(close>open) open=close=0;
        }
        open=close=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='(') open++;
            else close++;

            if(open==close)ans=Math.max(ans,open*2);
            else if(close<open) open=close=0;
        }
    return ans;    
    }
}