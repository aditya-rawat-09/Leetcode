class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        String ans = solve(freq, target, 0, false);

        return ans == null ? "" : ans;
    }

    String solve(int[] freq, String target, int index, boolean greater) {

        if (index == target.length()) {
            return greater ? "" : null;
        }

        for (int ch = 0; ch < 26; ch++) {

            if (freq[ch] == 0)
                continue;

            char c = (char) ('a' + ch);

            // If already greater, take remaining characters
            // in smallest order.
            if (greater) {

                freq[ch]--;

                StringBuilder ans = new StringBuilder();
                ans.append(c);

                for (int x = 0; x < 26; x++) {
                    while (freq[x] > 0) {
                        ans.append((char) ('a' + x));
                        freq[x]--;
                    }
                }

                return ans.toString();
            }

            // Can't choose a smaller character
            if (c < target.charAt(index))
                continue;

            freq[ch]--;

            boolean newGreater = c > target.charAt(index);

            String result = solve(
                freq,
                target,
                index + 1,
                newGreater
            );

            if (result != null) {
                return c + result;
            }

            // Backtrack
            freq[ch]++;
        }

        return null;
    }
}