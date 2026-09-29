class Solution {
    int m,n;
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        if ((m + n - 1) % 2 != 0) return false;
        if (grid[0][0] == ')' || grid[m-1][n-1] == '(') return false;
        
        dp=new Boolean[m][n][m+n];
        return dfs(grid,0,0,0);  
    }
    boolean dfs(char[][] grid,int i,int j, int balance){
        if(grid[i][j]=='(')balance+=1;
        else balance-=1;
        //base
        if(balance<0)return false;
        //already
        if(dp[i][j][balance]!=null)return dp[i][j][balance];
        //dest
        if(i==m-1 &&j==n-1)return dp[i][j][balance]=balance==0;
        //down
        boolean down=false;
        if(i+1<m)down=dfs(grid,i+1,j,balance);
        
        //right
        boolean right=false;
        if(j+1<n)right=dfs(grid,i,j+1,balance);

        return dp[i][j][balance]=down||right;
    }
}