class Solution {
    public int maximumProduct(int[] nums) {
        int a=Integer.MIN_VALUE,b=Integer.MIN_VALUE,c=Integer.MIN_VALUE,d=Integer.MAX_VALUE,e=Integer.MAX_VALUE,n=nums.length;
        for(int i=0;i<n;i++){
            int f=nums[i];

            if(f>=a){
                c=b;
                b=a;
                a=f;
            }else if(f>=b){
                c=b;
                b=f;
            }else if(f>c)c=f;

            if(d>=f){
                e=d;
                d=f;
            }else if(e>f){
                e=f;
                }
        }
    return Math.max(b*c*a,d*e*a);
    }
}