class Solution {
    public int minMoves(int[] nums) {
        int max=nums[0],ans=0;
        for(int num:nums){
            max=Math.max(num,max);
            ans+=num;
        }

        return nums.length*max-ans;  
    }
}