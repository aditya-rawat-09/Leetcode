class Solution {
    public int findGCD(int[] nums) {
        int a=1001;
        int b=-1;
        for(int i=0;i<nums.length;i++){
            if(a>nums[i])a=nums[i];
            if(b<nums[i])b=nums[i];
        }
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;   
    }
}