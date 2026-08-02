class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        Integer[][] dp=new Integer[n][n];

        return solve(piles,0,n-1,dp)>=0;
    }
    int solve(int[] piles,int l,int r,Integer[][] dp){
        if(l==r)return piles[l];
        if(dp[l][r]!=null)return dp[l][r];
        int left=piles[l]-solve(piles,l+1,r,dp);
        int right=piles[r]-solve(piles,l,r-1,dp);
        return dp[l][r]=Math.max(left,right);
    }
}