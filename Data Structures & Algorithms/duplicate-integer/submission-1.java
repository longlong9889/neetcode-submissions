class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
            else {
                return true;
            }
        }
        return false;
    }
}