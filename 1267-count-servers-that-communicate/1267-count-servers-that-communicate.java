class Solution {
    public int countServers(int[][] grid) {
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&server(grid,i,j))
                count+=1;
            }
        }
    return count;    
    }
    boolean server(int[][] grid,int i,int j){
        int m=grid.length;
        int n=grid[0].length;
        for(int a=0;a<n;a++){
            if(a!=j&&grid[i][a]==1)
            return true;
            } 
        for(int a=0;a<m;a++){
            if(a!=i && grid[a][j]==1)
            return true;
            } 

        return false;
    }
}