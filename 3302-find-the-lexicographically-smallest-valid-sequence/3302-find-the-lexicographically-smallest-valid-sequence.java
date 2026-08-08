class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // last[j] = position in word1 where word2[j]
        // can be matched while matching from right to left.
        int[] last = new int[m];
        Arrays.fill(last, -1);

        int j = m - 1;

        // Build last[] from right to left.
        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(j)) {
                last[j--] = i;
            }
        }

        int[] ans = new int[m];

        boolean changed = false;
        j = 0;

        // Greedily choose the smallest possible index.
        for (int i = 0; i < n && j < m; i++) {

            if (word1.charAt(i) == word2.charAt(j)) {
                // Characters match: always take it.
                ans[j++] = i;
            } 
            else if (!changed &&
                     (j == m - 1 || i < last[j + 1])) {

                // Use our one allowed modification.
                ans[j++] = i;
                changed = true;
            }
        }

        return j == m ? ans : new int[0];
    }
}