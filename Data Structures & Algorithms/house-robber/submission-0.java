class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int result = max(nums, nums.length, map);
        return result;
    }
    private int max(int[] nums, int i, Map<Integer, Integer> map) {
        if (i == 1) {
            return nums[0];
        }
        if (i == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (map.containsKey(i)) {
            return map.get(i);
        }
        int firstCase = max(nums, i - 2, map) + nums[i - 1];
        int secondCase = max(nums, i - 1, map);
        map.put(i, Math.max(firstCase, secondCase));
        return Math.max(firstCase, secondCase);
    }
}
