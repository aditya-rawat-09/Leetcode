class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] road: roads){
    graph.get(road[0]-1).add(new int[]{road[1]-1,road[2]});
    graph.get(road[1]-1).add(new int[]{road[0]-1,road[2]});
}

        Queue<Integer> q=new LinkedList<>();
        boolean[] visit=new boolean[n];
        int ans=Integer.MAX_VALUE;
        q.offer(0);
        visit[0]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            
            for(int[] next:graph.get(curr)){
            ans=Math.min(ans,next[1]);
            if(!visit[next[0]]){
                visit[next[0]]=true;
                q.add(next[0]);
            }
            }
        }
        return ans;
    }
}