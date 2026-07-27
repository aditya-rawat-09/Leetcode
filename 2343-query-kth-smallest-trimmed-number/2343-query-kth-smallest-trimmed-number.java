class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int m=nums.length;
        int n=queries.length;
        int[] ans= new int[n];
        for(int i=0;i<n;i+=1){
            int k=queries[i][0];
            int trim=queries[i][1];
            List<Integer> list=new ArrayList<>(m);
            for(int j=0;j<m;j+=1){
                list.add(j);
            }
            Collections.sort(list,(a,b)->{
                String s1=nums[a].substring(nums[a].length()-trim);
                String s2=nums[b].substring(nums[b].length()-trim);
                int cmp=s1.compareTo(s2);
                if(cmp!=0)return cmp;
                return Integer.compare(a,b);   
            });
            ans[i]=list.get(k-1);
        }
    return ans;   
    }
}