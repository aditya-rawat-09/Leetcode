class Solution {
    public int maxProduct(int n) {
        int a=0,b=0;
        while(n>0){
            int c=n%10;
           if(a<c){
            b=a;
            a=c;
           }else if(b<c)b=c;
            n/=10;
        }
    return a*b;    
    }
}