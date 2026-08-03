class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1]; // dp[i]: best diff for player to move, starting at i
        for (int i = n - 1; i >= 0; i--) {
            int best = Integer.MIN_VALUE, sum = 0;
            for (int k = 0; k < 3 && i + k < n; k++) {
                sum += stoneValue[i + k];
                best = Math.max(best, sum - dp[i + k + 1]);
            }
            dp[i] = best;
        }
        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
}