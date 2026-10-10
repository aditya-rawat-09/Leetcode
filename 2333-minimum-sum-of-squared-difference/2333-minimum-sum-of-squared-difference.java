class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] arr=new int[100001];
        int n=nums1.length,max=0;
        long k=(long)k1+k2,sum=0,ans=0;
        for(int i=0;i<n;i++){
            int diff=Math.abs(nums1[i]-nums2[i]);
            arr[diff]++;
            sum+=diff;
            max=Math.max(max,diff);
        }
        if(k>=sum)return 0;
        int curr=max;
        while(k>0){
            int c=arr[curr];
            if(c==0){
                curr--;
                continue;
            }
            int sub=Math.min(c,(int)k);
            arr[curr]-=sub;
            arr[curr-1]+=sub;
            k-=sub;
        }
        for (int d = 1; d <= max; d++) {
            ans += (long) arr[d] * d * d;
        }
        return ans;
        
    }
}