class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int avg=0;
        if(n%2==1){
            avg=nums[n/2];
        }else{
            avg=(nums[n/2-1]+nums[n/2])/2;
            
        }
        
        int ans=0;
        for(int num:nums)
        ans+=Math.abs(avg-num);

        return ans;
    }
}