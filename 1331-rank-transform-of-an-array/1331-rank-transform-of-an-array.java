class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        if(n==0)return new int[]{};
        int[] temp=arr.clone();
        Arrays.sort(temp);

        HashMap<Integer,Integer> map=new HashMap<>();
        int j=1;
        for(int ele : temp){
            if(!map.containsKey(ele)){
                map.put(ele , j++);
            }
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=map.get(arr[i]);

        }
        return ans;  
    }
}