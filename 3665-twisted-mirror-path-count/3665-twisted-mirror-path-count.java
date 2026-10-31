class Solution {
    int MOD = 1_000_000_007;
    int m, n;
    int[][] grid;
    long[][][] dp;

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        dp = new long[m][n][2];
        for (long[][] row : dp)
            for (long[] cell : row) Arrays.fill(cell, -1);
        return (int) dfs(0, 0, 0);
    }

    long dfs(int i,int j,int prev){

        if(i>m-1|| j>n-1)return 0;
        if(i==m-1 && j==n-1) return 1;
        if (dp[i][j][prev] != -1)
            return dp[i][j][prev];

        long count=0;
        if(grid[i][j]==0){
            count+=dfs(i,j+1,0);
            count+=dfs(i+1,j,1);
        }else{
            if(prev==0) count+=dfs(i+1,j,1);
            else  count+=dfs(i,j+1,0);
        }
        return dp[i][j][prev] = count % MOD;
    }
}