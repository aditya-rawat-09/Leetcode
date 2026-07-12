class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        boolean[][] vis=new boolean[m][n];
        int start=image[sr][sc];
        helper(image,sr,sc,color,vis,start);
        return image; 
    }
    void helper(int[][] image, int sr, int sc, int color,boolean[][] vis, int start){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=start||vis[sr][sc])return;
        vis[sr][sc] = true;
        image[sr][sc] = color;
        helper(image,sr+1,sc,color,vis,start);
        helper(image,sr-1,sc,color,vis,start);
        helper(image,sr,sc+1,color,vis,start);
        helper(image,sr,sc-1,color,vis,start);

    }
}