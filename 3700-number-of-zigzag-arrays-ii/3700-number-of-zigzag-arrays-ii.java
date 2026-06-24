class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int sz = r - l + 1; // values l..r mapped to indices 0..sz-1

        // Build M_odd: next[i] = sum dp[j] for j < i  (strict less)
        long[][] Modd = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            for (int j = 0; j < i; j++)   // j < i means value l+j < l+i
                Modd[i][j] = 1;

        // Build M_even: next[i] = sum dp[j] for j > i  (strict greater)
        long[][] Meven = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            for (int j = i + 1; j < sz; j++)
                Meven[i][j] = 1;

        // One full "round" = even step then odd step (or odd then even)
        // We start at step 0 (before any transition), apply n-1 transitions total.
        // Transition at step i (0-indexed i): i%2==0 means odd-index element chosen → use Modd
        // Easier: just build single-step matrix and do fast exponentiation n-1 times.

        long[][] M = (n % 2 == 0) ? Meven : Modd; // first transition
        // We need to apply transitions for steps 1..n-1 alternating odd/even
        // Use two-step matrix for bulk, handle remainder

        // Simpler: two-step matrix T = Meven * Modd (apply Modd first, then Meven)
        long[][] T = multiply(Meven, Modd, sz);

        // Initial vector: all 1s (any starting value in [l,r])
        long[] vec = new long[sz];
        java.util.Arrays.fill(vec, 1);

        int steps = n - 1; // transitions needed

        // Apply Modd first if steps is odd (first transition is always Modd since i=1 is odd)
        // Transitions: i=1 odd->Modd, i=2 even->Meven, i=3 odd->Modd ...
        // steps total: apply Modd ceil(steps/2) times, Meven floor(steps/2) times
        // Use T = Meven*Modd for pairs, then apply leftover Modd if steps is odd

        long[][] Tpow = matpow(T, steps / 2, sz);
        vec = matvec(Tpow, vec, sz);
        if (steps % 2 == 1) vec = matvec(Modd, vec, sz);

        long ans = 0;
        for (long v : vec) ans = (ans + v) % MOD;
        return (int) ((ans*2)%MOD);
    }

    long[][] multiply(long[][] A, long[][] B, int sz) {
        long[][] C = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            for (int k = 0; k < sz; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < sz; j++)
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
            }
        return C;
    }

    long[][] matpow(long[][] M, int p, int sz) {
        long[][] result = new long[sz][sz];
        for (int i = 0; i < sz; i++) result[i][i] = 1; // identity
        while (p > 0) {
            if ((p & 1) == 1) result = multiply(result, M, sz);
            M = multiply(M, M, sz);
            p >>= 1;
        }
        return result;
    }

    long[] matvec(long[][] M, long[] v, int sz) {
        long[] res = new long[sz];
        for (int i = 0; i < sz; i++)
            for (int j = 0; j < sz; j++)
                res[i] = (res[i] + M[i][j] * v[j]) % MOD;
        return res;
    }
}