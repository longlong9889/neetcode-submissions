class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        helper(nums, currentList, isUsed, res);
        return res;
    }
    private void helper(int[] nums, List<Integer> currentList, boolean[] isUsed, List<List<Integer>> res) {
        if (currentList.size() == nums.length) {
            res.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            isUsed[i] = true;
            currentList.add(nums[i]);
            helper(nums, currentList, isUsed, res);
            currentList.remove(currentList.size() - 1);
            isUsed[i] = false;
        }
    }
}
