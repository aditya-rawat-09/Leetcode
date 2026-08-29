class pair {
    int index;
    int value;

    pair(int value, int index) {
        this.index = index;
        this.value = value;
    }
}

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        pair[] pairs = new pair[n];

        // Create pairs
        for (int i = 0; i < n; i++) {
            pairs[i] = new pair(nums[i], i);
        }

        // Sort pairs by value
        Arrays.sort(pairs, (a, b) -> a.value - b.value);

        int start = 0;

        while (start < n) {

            int end = start;

            // Find the complete group
            while (end + 1 < n &&
                   pairs[end + 1].value - pairs[end].value <= limit) {
                end++;
            }

            int size = end - start + 1;

            int[] indices = new int[size];
            int[] values = new int[size];

            // Store indices and values
            for (int i = 0; i < size; i++) {
                indices[i] = pairs[start + i].index;
                values[i] = pairs[start + i].value;
            }

            // Sort original indices
            Arrays.sort(indices);

            // Values are already sorted
            for (int i = 0; i < size; i++) {
                nums[indices[i]] = values[i];
            }

            start = end + 1;
        }

        return nums;
    }
}