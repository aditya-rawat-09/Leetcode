class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num)return "";
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<num;i++){
            if(sum>9){
                ans.append('9');
                sum-=9;
            }
            else{
                ans.append(sum);
                sum-=sum;
            }
        }
    return ans.toString();    
    }
}