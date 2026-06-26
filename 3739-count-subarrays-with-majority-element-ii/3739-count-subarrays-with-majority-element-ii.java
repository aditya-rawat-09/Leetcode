class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        
        long ans = 0;
        long validCount = 0; // count of prefix[i] < prefix[j]
        int prefix = 0;
        freq.put(0, 1);
        
        for (int x : nums) {
            int prev = prefix;
            prefix += (x == target ? 1 : -1);
            
            if (prefix > prev) {
                // prefix went up by 1; prev values == prefix-1 (== prev) are now valid
                validCount += freq.getOrDefault(prev, 0);
            } else {
                // prefix went down by 1; values == prefix (== prev-1) are no longer valid
                validCount -= freq.getOrDefault(prefix, 0);
            }
            
            ans += validCount;
            freq.merge(prefix, 1, Integer::sum);
        }
        
        return ans;
        
    }
}