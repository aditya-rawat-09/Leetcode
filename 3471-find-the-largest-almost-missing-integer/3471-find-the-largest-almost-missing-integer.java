class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length,max=-1,maxx=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            maxx = Math.max(maxx, num);
            if (map.get(num) == 1) {
            max = Math.max(max, num);
            }
        }
        
        if(k==1)return max;
        else if(k==n)return maxx;
        else{
            int a=(map.get(nums[0])==1)?nums[0]:-1;
            int b=(map.get(nums[n-1])==1)?nums[n-1]:-1;
            return Math.max(a,b);
        }
    }
}