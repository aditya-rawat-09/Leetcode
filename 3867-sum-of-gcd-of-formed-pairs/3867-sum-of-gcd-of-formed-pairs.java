class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int maxx=-1;
        for(int i=0;i<n;i++){
            maxx=Math.max(nums[i],maxx);
            pre[i]=gcd(nums[i],maxx);
        }
        Arrays.sort(pre);
        long ans=0;
        for(int i=0,j=n-1;i<j;i++,j--){
            ans+=gcd(pre[i],pre[j]);
        }
        return ans;
        
    }
    int gcd(int a, int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}