class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<101;i=i+1){
            int j=pro(i);
            if(j%t==0)return i;
        }
     return 0;   
    }
    int pro(int i){
        int ans=1;
        while(i>0){
            ans*=(i%10);
            i/=10;
        }
        return ans;
    }
}