class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, list, res);
        return res;
    }
    private void backtrack(int[] nums, int index, List<Integer> currentList, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(currentList));
            return;
        }
        res.add(new ArrayList<>(currentList));
        for (int i = index; i < nums.length; i++) {
            currentList.add(nums[i]);
            backtrack(nums, i + 1, currentList, res);
            currentList.remove(currentList.size() - 1);
        }
    }
}
