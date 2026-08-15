class Solution {
    public int longestSubsequence(int[] nums) {
        boolean nonzero=false;
        int n=nums.length, xor=0;
        for(int num:nums){
            xor^=num;
            if(num!=0)nonzero=true;
        }
        if(xor!=0)return n;
        if(!nonzero)return 0;

        return n-1;   
    }
}