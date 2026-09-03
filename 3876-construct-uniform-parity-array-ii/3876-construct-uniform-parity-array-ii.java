class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        boolean arr=true;
        boolean arr1=true;
        int odd=Integer.MAX_VALUE;
        int even=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums1[i]<odd && nums1[i]%2==1)odd=nums1[i];
            else if(nums1[i]<even && nums1[i]%2==0)even=nums1[i];
        }
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0 && nums1[i]-odd<1){
                arr=false;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(nums1[i]%2==1 && nums1[i]-odd<1){
                arr1=false;
                break;
            }
        }
        return arr||arr1;
    }
}