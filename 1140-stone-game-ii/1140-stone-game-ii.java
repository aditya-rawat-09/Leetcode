import java.util.*;

class Solution {

    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        // suffix[i] = sum of piles from i to n-1
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        // dp[i][M]
        dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1);
    }

    private int solve(int i, int M) {

        // No piles left
        if (i == n) {
            return 0;
        }

        // Can take all remaining piles
        if (2 * M >= n - i) {
            return suffix[i];
        }

        // Already calculated
        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int maxStones = 0;

        // Try taking X piles
        for (int X = 1; X <= 2 * M; X++) {

            int opponent = solve(
                i + X,
                Math.max(M, X)
            );

            int currentPlayer = suffix[i] - opponent;

            maxStones = Math.max(maxStones, currentPlayer);
        }

        return dp[i][M] = maxStones;
    }
}