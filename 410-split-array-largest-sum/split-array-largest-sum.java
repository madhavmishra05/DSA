class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        for (int n : nums) {
            low = Math.max(low, n);
            high = high+ n;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean isPossible(int[] nums, int k, int maxSum) {
        int parts = 1;
        int sum = 0;

        for (int n : nums) {
            if (sum + n > maxSum) {
                parts++;
                sum = n;
                if (parts > k) return false;
            } else {
                sum += n;
            }
        }
        return true;
    }
}
