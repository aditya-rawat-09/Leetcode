class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int a=0,b=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(min>nums[i]){
                min=nums[i];
                a=i;
            }
            if(max<nums[i]){
                max=nums[i];
                b=i;
            }
        }
        int big=Math.max(a,b);
        int small=a+b-big;
        return Math.min(big+1,Math.min(n-small,small+1+n-big));
        
    }
}