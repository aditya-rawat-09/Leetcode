class Solution {
    public int sortPermutation(int[] nums) {
        int ans=0,n=nums.length,count=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=i){
                if(count==0){
                    ans=nums[i];
                }else{
                    ans&=nums[i];
                }
                count++;
            }
        }
    return ans;    
    }
}