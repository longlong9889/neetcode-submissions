class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        Boolean[][] memo = new Boolean[nums.length][sum / 2 + 1];
        return dfs(nums, sum / 2, 0, memo);
    }
    private boolean dfs(int[] nums, int target, int index, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }
        if (index == nums.length || target < 0) {
            return false;
        }
        if (memo[index][target] != null) {
            return memo[index][target];
        }
        boolean take = dfs(nums, target - nums[index], index + 1, memo);
        boolean skip = dfs(nums, target, index + 1, memo);
        memo[index][target] = take || skip;
        return memo[index][target];
    }
}
