class Solution {
    public String digitSum(String s, int k) {
        int l=s.length();
        String temp=s;
        
        while(l>k){
            temp=help(temp,k);
            l=temp.length();
        }
        return temp;   
    }
    String help(String s,int k){
        StringBuilder sb=new StringBuilder();
        int temp=0;
        for(int i=0;i<s.length();i++){
            temp+=s.charAt(i)-'0';
            if((i+1)%k==0||i+1==s.length()){
                sb.append(temp);
                temp=0;
            }
        }
        return sb.toString();
    }
}