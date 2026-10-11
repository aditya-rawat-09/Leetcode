class Solution {
    public int sumOfSquares(int[] nums) {
        int n=nums.length;
        int ans=nums[n-1]*nums[n-1];
        for(int i=0;i<n-1;i++){
            if(n%(i+1)==0){
                ans+=nums[i]*nums[i];
            }
        }
    return ans;  
    }
}