class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, currentList, res, 0);
        return res;
    }
    private void helper(int[] nums, List<Integer> currentList, List<List<Integer>> res, int index) {
        res.add(new ArrayList<>(currentList));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            currentList.add(nums[i]);
            helper(nums, currentList, res, i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}
