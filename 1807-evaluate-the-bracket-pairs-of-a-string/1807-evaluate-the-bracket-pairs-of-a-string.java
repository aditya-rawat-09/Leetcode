class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        for(List<String> str:knowledge){
            map.put(str.get(0),str.get(1));
        }

        StringBuilder ans=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                int j=i;
                while(s.charAt(j)!=')'){
                    j++;
                }
                String temp=s.substring(i+1,j);
                ans.append(map.getOrDefault(temp,"?"));
                i=j;
            }else{
                ans.append(s.charAt(i));
            }
        }
    return ans.toString();   
    }
}