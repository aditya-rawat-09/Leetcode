class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int max=nums[0],min=nums[n-1];
        int[] minarr=new int[n];
        for(int i=n-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            minarr[i]=min;
        }
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            if(max-minarr[i]<=k)return i;
        }
        return -1;
    }
}