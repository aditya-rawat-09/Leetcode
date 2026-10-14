class Solution {
    private boolean palindrome(String sb){
        int i=0,j=sb.length()-1;
        while(i<j){
            if(sb.charAt(i)!=sb.charAt(j))return false;
            i++;
            j--;
        }
        return true;
        
    }
    public String longestPalindrome(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                String sub = s.substring(i, j + 1);

                if (palindrome(sub) && sub.length() > ans.length()) {
                    ans = sub;
                }
            }
        }

        return ans;   
    }
}