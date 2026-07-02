class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size(),n=grid.get(0).size();
        int[][] cost=new int[m][n];
        for(int[] row:cost)Arrays.fill(row,-1);
        
        Deque<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{0,0});
        cost[0][0]=grid.get(0).get(0);

        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0],c=curr[1];

            for(int[] dir:dirs){
                int nr=r+dir[0],nc=c+dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                int w = grid.get(nr).get(nc); 
                int newCost = cost[r][c] + w;
                   if (cost[nr][nc] == -1 || newCost < cost[nr][nc]) {          
                    cost[nr][nc] = newCost;
                    if (w == 0) q.offerFirst(new int[]{nr, nc});
                    else q.offerLast(new int[]{nr, nc});
                }

            }
        }
    return cost[m-1][n-1] < health;    
    }
}