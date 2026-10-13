class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        int m=n/2;
        long ans=0;
        if(n%2==1)ans+=nums[m];
        for(int i=0;i<m;i++){
            ans+=nums[n-i-1];
            ans-=nums[i];
        }
    return ans;    
    }
}