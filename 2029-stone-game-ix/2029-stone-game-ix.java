class Solution {
    public boolean stoneGameIX(int[] stones) {
        int a=0,b=0,c=0;
        for(int num:stones){
            int rem=num%3;
            if(rem==0)c=c+1;
            else if(rem==1)a=a+1;
            else b=b+1;
        }
        if(c%2==0)return a>0&&b>0;

        return Math.abs(a-b)>2; 
    }
}