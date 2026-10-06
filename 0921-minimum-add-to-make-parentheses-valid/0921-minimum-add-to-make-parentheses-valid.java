class Solution {
    public int minAddToMakeValid(String s) {
        int ans=0,temp=0;
        for(char c:s.toCharArray()){
            if(c=='(')temp++;
            else{
                temp--;
                if(temp<0){
                    temp++;
                    ans+=1;
                }
            }
        }
    return ans+temp;    
    }
}