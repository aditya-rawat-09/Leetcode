class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int targetcount=0,total=0;
            for(int j=i;j<n;j++){
                if(nums[j]==target)targetcount++;
                total++;
                if(2*targetcount>total)count++;

            }
        }
        return count;
        
    }
}