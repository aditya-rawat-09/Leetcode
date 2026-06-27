class Solution {
    public int maximumLength(int[] nums) {
        Map<Long,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put((long)num,map.getOrDefault((long)num,0)+1);
        }
        int ans=1;
        if(map.containsKey(1L)){
            int one=map.get(1L);
            ans=(one&1)==0?one-1:one;
        }
        for(long num:map.keySet()){
            if(num==1)continue;
            long curr=num;
            int count=0;
            while(map.containsKey(curr)){
                if(map.get(curr)>=2){
                    count+=2;
                    curr*=curr;
                }else{
                    count++;
                    break;
                }
            }
        if((count&1)==0)count--;
        ans=Math.max(count,ans);
            
        }
    return ans;    
    }
}