class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Compute indegree and build graph
        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add all nodes with indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            ans[index++] = node;

            for (int neighbor : adj.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Cycle exists
        if (index != numCourses) {
            return new int[0];
        }

        return ans;
    }
}