
import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {

        int n = s.length();
        int INF = 100000;

        // Step 1: Precompute substring costs
        int[][] cost = new int[n][n];

        for (int[] row : cost) {
            Arrays.fill(row, INF);
        }

        for (int len = 2; len <= n; len++) {

            // Find proper divisors
            for (int d = 1; d < len; d++) {

                if (len % d != 0) continue;

                int groups = len / d;

                for (int start = 0; start + len <= n; start++) {

                    int changes = 0;

                    // Compare characters in each group
                    for (int r = 0; r < d; r++) {

                        for (int p = 0; p < groups / 2; p++) {

                            int left = start + r + p * d;

                            int right = start + r
                                    + (groups - 1 - p) * d;

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                        }
                    }

                    cost[start][start + len - 1] =
                            Math.min(cost[start][start + len - 1],
                                     changes);
                }
            }
        }

        // Step 2: DP
        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {

            for (int i = 2 * p; i <= n; i++) {

                for (int j = 2 * (p - 1); j <= i - 2; j++) {

                    if (dp[p - 1][j] == INF) continue;

                    dp[p][i] = Math.min(
                        dp[p][i],
                        dp[p - 1][j] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
