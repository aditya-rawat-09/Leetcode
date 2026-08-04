class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max=0,min=101,n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>max)max=nums[i];
            if(nums[i]<min)min=nums[i];
        }
        HashSet<Integer> map=new HashSet<>(n);
        for(int num:nums){
            map.add(num);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=min;i<max;i++){
            if(!map.contains(i))ans.add(i);
        }
    return ans;    
    }
}