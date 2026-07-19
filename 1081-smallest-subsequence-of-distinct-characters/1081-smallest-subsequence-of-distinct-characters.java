class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();

        // Store the last occurrence of each character
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        // Check if a character is already in the stack
        boolean[] visited = new boolean[26];

        // Using StringBuilder as a stack
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // Skip if already present
            if (visited[ch - 'a']) {
                continue;
            }

            // Remove larger characters if they appear later
            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > ch &&
                   last[stack.charAt(stack.length() - 1) - 'a'] > i) {

                visited[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }

            stack.append(ch);
            visited[ch - 'a'] = true;
        }

        return stack.toString();
    }
}