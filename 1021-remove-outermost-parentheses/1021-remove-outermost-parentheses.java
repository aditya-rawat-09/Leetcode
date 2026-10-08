class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans=new StringBuilder();
        int temp=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if (temp > 0) {
                    ans.append(s.charAt(i));
                }
                temp++;
            }else{
                temp--;
                if (temp > 0) {
                    ans.append(s.charAt(i));
                }
            }
        }
        return ans.toString();
    }
}