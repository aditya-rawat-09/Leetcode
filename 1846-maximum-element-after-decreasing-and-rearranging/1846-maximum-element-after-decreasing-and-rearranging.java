class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        arr[0]=1;
        int j=1;
        for(int i=1;i<n;i++){
            if(arr[i]==j)continue;
            else if(arr[i]==j+1 || arr[i]== -1)j=arr[i];
            else {
                arr[i]=j+1;
                j++;
            }

        }
    return arr[n-1];    
    }
}