class Solution {
    int count;
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        count=0;
        boolean[] used=new boolean[n];
        helper(digits,used,0);
        return count;
    }
    void helper(int[] digits,boolean[] used,int idx){
        if(idx==3 ){
            count+=1;
            return;
        }
        boolean[] seen = new boolean[10];
       for(int i=0;i<digits.length;i++){
        if(used[i])continue;
        if(idx==0&&digits[i]==0)continue;
        if (seen[digits[i]]) continue;
        if(idx==2&& digits[i]%2==1)continue;
        used[i]=true;
        seen[digits[i]] = true;
        helper(digits,used,idx+1);
        used[i]=false;
       }
    }
}