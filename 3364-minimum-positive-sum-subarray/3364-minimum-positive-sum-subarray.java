class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int result=Integer.MAX_VALUE;


        
            for(int i=0;i<n;i++){
                int currSum=0;
                for (int j = i; j < n && (j - i + 1) <= r; ++j) {
                currSum += nums.get(j);

                if ((j - i + 1) >= l && currSum > 0) {
                    result = Math.min(result, currSum);
                    }
                }
                 
            }

    return result==Integer.MAX_VALUE?-1:result;    
    }
}