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
        int l=0,r=n-1;
        while(l<r) {
            ans+=gcd(pre[l++],pre[r--]);
        }
        return ans;
        
    }
    int gcd(int a, int b){
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}