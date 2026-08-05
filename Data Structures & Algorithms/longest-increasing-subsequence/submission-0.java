class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            if (nums[0] < nums[1]) {
                return 2;
            }
            else {
                return 1;
            }
        }
        int max = Integer.MIN_VALUE;
        int currentMax = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            currentMax = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    currentMax = Math.max(currentMax, dp[j] + 1); 
                }
            }
            dp[i] = Math.max(dp[i], currentMax);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
