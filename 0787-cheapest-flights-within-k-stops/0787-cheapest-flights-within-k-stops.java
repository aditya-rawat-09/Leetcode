class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dest=new int[n];
        Arrays.fill(dest,Integer.MAX_VALUE);
        dest[src]=0;
        for(int i=0;i<=k;i++){
            int[] temp=dest.clone();
            for(int[] fight:flights){
                int u=fight[0];
                int v=fight[1];
                int w=fight[2];
                if(dest[u]!=Integer.MAX_VALUE && dest[u]+w<temp[v]){
                    temp[v]=dest[u]+w;
                }
            }
            dest=temp;
        }
    return dest[dst] == Integer.MAX_VALUE ? -1 : dest[dst];    
    }
}