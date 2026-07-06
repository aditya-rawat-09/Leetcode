class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);        
        int remove=0;
        int i=0;
        for(int j= 1;j<n;j++){
            int start=intervals[j][0], end=intervals[j][1];
            int pstart=intervals[i][0],pend=intervals[i][1];
            if(start>=pstart && end<=pend)remove++;
            else i=j;
        }
        return n-remove;
    }
}