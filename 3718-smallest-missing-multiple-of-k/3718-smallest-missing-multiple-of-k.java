class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> map=new HashSet<>();
        for(int num:nums)map.add(num);

        for(int i=k;i<=200;i+=k){
            if(!map.contains(i))return i;
        }
    return 0;    
    }
}