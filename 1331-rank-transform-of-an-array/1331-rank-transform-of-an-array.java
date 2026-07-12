class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        if(n==0)return new int[]{};
        int[] temp=arr.clone();
        Arrays.sort(temp);

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(temp[0],1);
        int j=1;
        for(int i=1;i<n;i++){
            if(temp[i]>temp[i-1])j++;
            map.put(temp[i],j);      
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=map.get(arr[i]);

        }
        return ans;  
    }
}