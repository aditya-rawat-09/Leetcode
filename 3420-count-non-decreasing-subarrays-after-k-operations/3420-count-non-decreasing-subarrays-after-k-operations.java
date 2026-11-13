class Solution {

    static class Pair {
        int val;
        int count;

        Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        Deque<Pair> dq = new ArrayDeque<>();

        long ans = 0;
        long cost = 0;

        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            // Add current element from the left
            while (!dq.isEmpty() && dq.peekLast().val < num) {

                Pair p = dq.pollLast();

                cost += (long) (num - p.val) * p.count;

                count += p.count;
            }

            dq.offerLast(new Pair(num, count));

            // Shrink window if operations exceed k
            while (cost > k) {

                Pair p = dq.pollFirst();

                cost -= (long) (p.val - nums[j]);

                if (p.count > 1) {
                    dq.offerFirst(new Pair(p.val, p.count - 1));
                }

                j--;
            }

            // Count valid subarrays
            ans += j - i + 1;
        }

        return ans;
    }
}
