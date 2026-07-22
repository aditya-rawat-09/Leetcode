class ST {
    int n;
    int[] st;

    public ST(int[] pairs) {
        n = pairs.length;
        st = new int[4 * n];
        build(pairs, 1, 0, n - 1);
    }

    private int build(int[] pairs, int node, int l, int r) {
        if (l == r) {
            st[node] = pairs[l];
            return st[node];
        }
        int mid = l + (r - l) / 2;
        int lc = build(pairs, node * 2, l, mid);
        int rc = build(pairs, node * 2 + 1, mid + 1, r);
        st[node] = Math.max(lc, rc);
        return st[node];
    }

    public int query(int node, int l, int r, int ql, int qr) {
        if (l > qr || r < ql) return 0;
        if (ql <= l && r <= qr) return st[node];
        int mid = l + (r - l) / 2;
        int lc = query(node * 2, l, mid, ql, qr);
        int rc = query(node * 2 + 1, mid + 1, r, ql, qr);
        return Math.max(lc, rc);
    }
}

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int ones = 0;
        List<int[]> zeros = new ArrayList<>();

        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int j = i;
                while (j < n && s.charAt(j) == s.charAt(i)) j++;
                zeros.add(new int[]{i, j - 1}); // [l, r]
                i = j;
            } else {
                ones++;
                i++;
            }
        }

        List<Integer> res = new ArrayList<>();

        if (zeros.size() < 2) {
            for (int k = 0; k < queries.length; k++) res.add(ones);
            return res;
        }

        int[] pairs = new int[zeros.size() - 1];
        for (int idx = 1; idx < zeros.size(); idx++) {
            int[] z1 = zeros.get(idx - 1);
            int[] z2 = zeros.get(idx);
            pairs[idx - 1] = (z1[1] - z1[0] + 1) + (z2[1] - z2[0] + 1);
        }
        ST st = new ST(pairs);

        int[] starts = new int[zeros.size()];
        int[] ends = new int[zeros.size()];
        for (int idx = 0; idx < zeros.size(); idx++) {
            starts[idx] = zeros.get(idx)[0];
            ends[idx] = zeros.get(idx)[1];
        }

        for (int[] query : queries) {
            int l = query[0], r = query[1];

            int first = lowerBound(ends, l);        // bisect_left(ends, l)
            int last = upperBound(starts, r) - 1;    // bisect_right(starts, r) - 1

            if (first >= last) {
                res.add(ones);
                continue;
            }

            int best = st.query(1, 0, st.n - 1, first + 1, last - 2);

            // touching left
            int[] zFirst = zeros.get(first);
            int[] zFirstNext = zeros.get(first + 1);
            int prevLen = Math.min(zFirst[1], r) - Math.max(zFirst[0], l) + 1;
            int nextLen = Math.min(zFirstNext[1], r) - Math.max(zFirstNext[0], l) + 1;
            best = Math.max(best, prevLen + nextLen);

            // touching right
            int[] zLastPrev = zeros.get(last - 1);
            int[] zLast = zeros.get(last);
            prevLen = Math.min(zLastPrev[1], r) - Math.max(zLastPrev[0], l) + 1;
            nextLen = Math.min(zLast[1], r) - Math.max(zLast[0], l) + 1;
            best = Math.max(best, prevLen + nextLen);

            res.add(ones + best);
        }

        return res;
    }

    // equivalent to bisect.bisect_left
    private int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // equivalent to bisect.bisect_right
    private int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}