class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        char[] ch=s.toCharArray();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(ch[i]=='(')st.push(i);
            else if(ch[i]==')'){
                int left=(st.pop()+1), right=i-1;
                
                while(left<right){
                    char temp=ch[left];
                    ch[left]=ch[right];
                    ch[right]=temp;
                    left++;
                    right--;
                }
            }

        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            if(ch[i]<'a'||ch[i]>'z')continue;
            ans.append(ch[i]);
        }
    return ans.toString();    
    }
}