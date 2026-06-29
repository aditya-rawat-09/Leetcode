class Solution {
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
        if (source == target) return new long[]{0, power};
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) g[e[0]].add(new int[]{e[1], e[2]});

        long[][] dist = new long[n][power + 1];
        for (long[] r : dist) Arrays.fill(r, Long.MAX_VALUE);
        dist[source][power] = 0;

        // FIX: sort by time only
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        q.offer(new long[]{0, source, power});

        while (!q.isEmpty()) {
            long[] c = q.poll();
            int u = (int) c[1], p = (int) c[2];
            long t = c[0];
            if (t > dist[u][p]) continue;
            if (p < cost[u]) continue;
            for (int[] e : g[u]) {
                int v = e[0], np = p - cost[u];
                long nt = t + (long) e[1];
                if (nt < dist[v][np]) {
                    dist[v][np] = nt;
                    q.offer(new long[]{nt, v, np});
                }
            }
        }

        long b = Long.MAX_VALUE; int bp = -1;
        for (int p = 0; p <= power; p++) {
            long val = dist[target][p];
            if (val < b || (val == b && p > bp)) { b = val; bp = p; }
        }
        return b == Long.MAX_VALUE ? new long[]{-1, -1} : new long[]{b, bp};
    }
}