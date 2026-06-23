class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int mod=1000000007;
        int[] dp= new int[r+1];
        Arrays.fill(dp,1);

        for(int i=1;i<n;i++){
            int[] next= new int[r+1];
            if(i%2==1){
                long pre=0;
                for(int x=l;x<=r;x++){
                    next[x] = (int) (pre % mod);
                    pre += dp[x];

                }
            }else{
                long suff=0;
                for(int x=r;x>=l;x--){
                    next[x]=(int)(suff%mod);
                    suff+=dp[x];
                }
            }
            dp=next;
        }
        long count=0;
       for (int x = l; x <= r; x++) count += dp[x];
        return (int) ((count*2) % mod);   
    }
}