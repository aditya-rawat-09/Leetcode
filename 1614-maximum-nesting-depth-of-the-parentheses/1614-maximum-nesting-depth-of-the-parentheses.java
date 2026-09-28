class Solution {
    public int maxDepth(String s) {
        int ans=0,temp=0;
        for(char ch:s.toCharArray()){
            if(ch=='(')temp++;
            else if(ch==')')temp--;
            ans=Math.max(ans,temp);
        }
    return ans;    
    }
}