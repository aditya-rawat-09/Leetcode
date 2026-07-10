class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Pair (value, originalIndex), sorted by value
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> nums[a] - nums[b]);

        int[] sortedVals = new int[n];
        int[] origToSorted = new int[n]; // originalIndex -> sorted position
        for (int i = 0; i < n; i++) {
            sortedVals[i] = nums[order[i]];
            origToSorted[order[i]] = i;
        }

        int maxLevel = Integer.SIZE - Integer.numberOfLeadingZeros(Math.max(n, 1)) + 1;
        int[][] jump = new int[n][maxLevel];

        // level 0: farthest directly-reachable index via two pointers
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (right < i) right = i;
            while (right + 1 < n && sortedVals[right + 1] - sortedVals[i] <= maxDiff) right++;
            jump[i][0] = right;
        }

        // binary lifting table
        for (int level = 1; level < maxLevel; level++) {
            for (int i = 0; i < n; i++) {
                jump[i][level] = jump[jump[i][level - 1]][level - 1];
            }
        }

        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int s = origToSorted[queries[q][0]];
            int e = origToSorted[queries[q][1]];
            if (s > e) { int t = s; s = e; e = t; }
            ans[q] = minJumps(jump, s, e, maxLevel - 1);
        }
        return ans;
    }

    private int minJumps(int[][] jump, int start, int end, int level) {
        if (start == end) return 0;
        if (jump[start][0] >= end) return 1;
        if (jump[start][level] < end) return -1; // can't reach even with max jumps

        int steps = 0;
        while (start != end) {
            if (jump[start][0] >= end) return steps + 1;
            int j = 0;
            // find largest jump that doesn't overshoot `end`
            for (int k = level; k >= 0; k--) {
                if (jump[start][k] < end) { j = k; break; }
            }
            if (jump[start][j] == start) return -1; // stuck, no progress possible
            steps += (1 << j);
            start = jump[start][j];
        }
        return steps;
    }
}