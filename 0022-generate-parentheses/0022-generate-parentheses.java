class Solution {
    List<String> ans=new ArrayList<>();
    int m;
    void helper(StringBuilder sb,int open,int close){
        if(sb.length()==2*m){
        ans.add(sb.toString());
        return;
        }
        if(open<m){
            sb.append('(');
            helper(sb,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }
         if(close<open){
            sb.append(')');
            helper(sb,open,close+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public List<String> generateParenthesis(int n) {
        m=n;
        StringBuilder sb=new StringBuilder();
        helper(sb,0,0);
        return ans;    
    }
}