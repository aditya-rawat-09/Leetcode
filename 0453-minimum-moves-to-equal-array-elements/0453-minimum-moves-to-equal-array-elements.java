class Solution {
    public int minMoves(int[] nums) {
        long sum=0,min=Long.MAX_VALUE;
        for(int num:nums){
            sum+=num;
            if(num<min)min=num;
        }
        return (int)(sum-(nums.length)*min);
    }
}