class Solution {
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int left=(n-1)/2;
        int right=n-1;
        for(int i=0;i<n;i+=2){
            nums[i]=temp[left--];
            if(i+1<n)nums[i+1]=temp[right--];
        }   
    }
}