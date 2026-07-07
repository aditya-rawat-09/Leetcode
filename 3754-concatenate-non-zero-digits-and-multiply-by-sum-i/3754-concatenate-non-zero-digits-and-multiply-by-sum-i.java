class Solution {
    public long sumAndMultiply(int n) {
        if(n==0)return 0;
        long sum=0,digit=0,i=1;
        while(n>0){
            long a=n%10;
            n/=10;
           if(a==0)continue;
           sum+=a;
           digit+=i*a;
           i*=10;
        }
        return sum*digit;
        
    }
}