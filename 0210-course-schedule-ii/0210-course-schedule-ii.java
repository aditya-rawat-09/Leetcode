class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        int[] indegree=new int[numCourses];
        int[] ans=new int[numCourses];
        for(int i=0;i<n;i++){
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.offer(i);
        }
        int k=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[k]=node;
            for(int i=0;i<n;i++){
                if(prerequisites[i][1]==node){
                int neighbor = prerequisites[i][0];
                indegree[neighbor]--;

                    if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                    }
                }
            }
            k++;
        }
        if (k != numCourses) return new int[0];
    return ans;
    }
}