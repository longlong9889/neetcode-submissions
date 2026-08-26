class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, 0, currentList, res);
        return res;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> currentList, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            currentList.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, currentList, res);
            currentList.remove(currentList.size() - 1);
        }
    }
}
