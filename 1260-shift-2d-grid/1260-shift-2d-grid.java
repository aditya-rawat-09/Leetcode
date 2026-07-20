class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length,total=m*n;
        int[][] ans=new int[m][n];
        k %= total;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int idx=(i*n+j+k)%total;
                int r=idx/n;
                int c=idx%n;    
                ans[r][c]=grid[i][j];
            }
        }

        List<List<Integer>> res=new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                list.add(ans[i][j]);
            }
            res.add(list);
        }
        return res;   
    }
}