class Solution {
    public long shadowPairs(int[] nums) {
        int n=nums.length;
        long ans=0;
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> run=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()>nums[i]){
                stack.pop();
                run.pop();
            }
            int eq = (!stack.isEmpty() && stack.peek()==nums[i]) ? run.peek() : 0;  // NEW
            ans += stack.size() - eq;       // CHANGED: exclude equal values (need nums[i] < nums[j])
            stack.push(nums[i]);
            run.push(eq+1);     
        }
        return ans;
    }
}