class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans="";
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int one=0;
                for(int str=i;str<=j;str++){
                    if(s.charAt(str)=='1')one++;
                }
                if(one==k){
                    String curr=s.substring(i,j+1);
                    if(ans.equals("")|| curr.length() < ans.length()|| (curr.length() == ans.length()&& curr.compareTo(ans) < 0)) 
                        ans = curr;
                }
            }
        }  
    return ans;      
    }
}