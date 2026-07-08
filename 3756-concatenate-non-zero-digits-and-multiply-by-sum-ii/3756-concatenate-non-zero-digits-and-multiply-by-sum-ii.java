class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final int MOD = 1_000_000_007;
        int m = s.length();
        long[] prefix = new long[m + 1];   // concatenated value mod MOD
        int[] cnt = new int[m + 1];        // count of non-zero digits so far
        long[] digitSum = new long[m + 1]; // running sum of non-zero digits
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) pow10[i] = pow10[i - 1] * 10 % MOD;

        for (int i = 0; i < m; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                prefix[i + 1] = (prefix[i] * 10 + d) % MOD;
                cnt[i + 1] = cnt[i] + 1;
                digitSum[i + 1] = digitSum[i] + d;
            } else {
                prefix[i + 1] = prefix[i];
                cnt[i + 1] = cnt[i];
                digitSum[i + 1] = digitSum[i];
            }
        }

        int n = queries.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int l = queries[i][0], r = queries[i][1];
            int cRange = cnt[r + 1] - cnt[l];
            long x = (prefix[r + 1] - prefix[l] * pow10[cRange] % MOD + MOD) % MOD;
            long sum = digitSum[r + 1] - digitSum[l];
            answer[i] = (int) (x * (sum % MOD) % MOD);
        }
        return answer;
    }
}