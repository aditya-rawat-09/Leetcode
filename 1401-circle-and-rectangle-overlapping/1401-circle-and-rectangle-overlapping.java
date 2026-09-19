class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x=0,y=0;
        if(x2<xCenter)x=x2;
        else if(x1>xCenter)x=x1;
        else x=xCenter;

        if(y2<yCenter)y=y2;
        else if(y1>yCenter)y=y1;
        else y=yCenter;

        int d=(int)Math.sqrt((x-xCenter)*(x-xCenter)+(y-yCenter)*(y-yCenter));
        return radius>=d;
        
    }
}