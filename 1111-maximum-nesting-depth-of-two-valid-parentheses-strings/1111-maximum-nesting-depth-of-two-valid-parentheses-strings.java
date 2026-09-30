class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
        int[] ans=new int[n];
        int depth=-1,i=0;
        for(char c:seq.toCharArray()){
            if(c=='('){
                depth++;
                ans[i]=depth%2==1?0:1;
            }else if(c==')'){
                ans[i]=depth%2==1?0:1;
                depth++;
            }
            i++;
        }
    return ans;    
    }
}