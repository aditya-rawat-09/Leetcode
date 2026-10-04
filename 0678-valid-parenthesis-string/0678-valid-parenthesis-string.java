class Solution {
    Boolean[][] dp;

    public boolean checkValidString(String s) {
        dp = new Boolean[s.length()][s.length() + 1];
        return helper(s, 0, 0);
    }

    public boolean helper(String s, int i, int open) {

        if (open > s.length() / 2|| open<0) {
            return false;
        }

        if (i == s.length()) {
            return open == 0;
        }

        if (dp[i][open] != null) {
            return dp[i][open];
        }

        char ch = s.charAt(i);

        if (ch == '(') {
            return dp[i][open] = helper(s, i + 1, open + 1);
        }

        if (ch == ')') {
            return dp[i][open] = helper(s, i + 1, open - 1);
        }

        // '*'
        return dp[i][open] =
            helper(s, i + 1, open) ||        // empty
            helper(s, i + 1, open + 1) ||    // '('
            helper(s, i + 1, open - 1);      // ')'
    }
}