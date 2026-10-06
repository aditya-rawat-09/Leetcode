class Solution {
    int helper(int i,int j,int[][] grid){
        int ans=4;
        int m=grid.length,n=grid[0].length;
        if(i-1>=0){
            if(grid[i-1][j]==1)ans-=1;
        }
        if(i+1<m){
            if(grid[i+1][j]==1)ans-=1;
        }
        
        if(j-1>=0){
            if(grid[i][j-1]==1)ans-=1;
        }
        if(j+1<n){
            if(grid[i][j+1]==1)ans-=1;
        }
        return ans;
    }
    public int islandPerimeter(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ans+=helper(i,j,grid);
                }
            }
        }
    return ans;    
    }
}