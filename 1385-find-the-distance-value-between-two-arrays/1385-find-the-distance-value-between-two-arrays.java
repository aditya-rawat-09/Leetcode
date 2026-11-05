class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=arr1.length;
        for(int num1:arr1){
            for(int num2:arr2){
                if(Math.abs(num1-num2)<=d){
                    count-=1;
                    break;
                }
            }
        }
    return count;    
    }
}