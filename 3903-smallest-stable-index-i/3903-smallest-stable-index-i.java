class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n=nums.length;
        int min=nums[n-1],max=nums[0];
        int[] minarr=new int[n];
        for(int i=n-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            minarr[i]=min;
        }
        for(int i=0;i<n;i++){
            max=Math.max(nums[i],max);
            
            if(max-minarr[i]<=k) return i;
        }
    return -1;    
    }
}