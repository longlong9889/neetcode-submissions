class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, target, 0, currentList, res);
        return res;
    }
    private void helper(int[] nums, int target, int index, List<Integer> currentList, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            currentList.add(nums[i]);
            helper(nums, target - nums[i], i, currentList, res);
            currentList.remove(currentList.size() - 1);
        }
    }
}
