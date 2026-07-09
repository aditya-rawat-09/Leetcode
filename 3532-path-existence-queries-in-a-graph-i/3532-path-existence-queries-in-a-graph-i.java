class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp=new int[n];
        for(int i=1;i<n;i++){
            int diff=Math.abs(nums[i]-nums[i-1]);
            if(diff<=maxDiff)comp[i]=comp[i-1];
            else comp[i]=i;
        }

        int m=queries.length;
        boolean[] ans=new boolean[m];
        for(int i=0;i<m;i++){
            int a=queries[i][0],b=queries[i][1];
            if(comp[a]==comp[b])ans[i]=true;
        }
    return ans;    
    }
}