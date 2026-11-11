class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long need=Math.min(need1,need2);
        need1-=need;
        need2-=need;
        long ans=need*Math.min((long)costBoth,(long)cost1+cost2);
        if(need1!=0){
            ans+=(long)need1*Math.min(costBoth,cost1);
        }
        if(need2!=0){
            ans+=(long)need2*Math.min(costBoth,cost2);
        }
    return ans;   
    }
}