class Solution {
    HashMap<Integer,List<Integer>> map;
    boolean[] vis;
    public int countCompleteComponents(int n, int[][] edges) {
        map=new HashMap<>();
        vis=new boolean[n];
        for(int[] edge:edges){
            int src=edge[0],des=edge[1];
            if(!map.containsKey(src)){
                map.put(src,new ArrayList<>());
            }
            if(!map.containsKey(des)){
                map.put(des,new ArrayList<>());
            }
            map.get(src).add(des);
            map.get(des).add(src);
        }
            int ans=0;
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    int[] temp=dfs(i);
                    int no=temp[0],e=temp[1];
                    if((no*(no-1))==e||no==1)ans++;
                }
            }
    return ans;    
    }
    int[] dfs(int node){
        int[] res=new int[2];
        vis[node]=true;
        res[0]++;
        List<Integer>list=map.get(node);
        if(list==null)return res;
        res[1]+=list.size();
        for(int i=0;i<list.size();i++){
            if(vis[list.get(i)])continue;
            int[]t=dfs(list.get(i));
            res[0]+=t[0];
            res[1]+=t[1];
        }
        return res;
    }
}