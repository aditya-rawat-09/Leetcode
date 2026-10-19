class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count=0,total=0;
        for(int num:nums){
            if(num<target)count++;
            else if(num==target)total++;
        }
        List<Integer> ans =new ArrayList<>(total);
        for(int i=0;i<total;i++){
            ans.add(count++);
        }
    return ans;    
    }
}