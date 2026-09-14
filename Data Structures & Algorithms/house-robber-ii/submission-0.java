class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        int[] firstChoice = new int[nums.length - 1];
        int[] secondChoice = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            firstChoice[i] = nums[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            secondChoice[i] = nums[i + 1];
        }
        Map<Integer, Integer> mapFirst = new HashMap<>();
        int maxFirstChoice = robMax(firstChoice, mapFirst, firstChoice.length - 1);
        Map<Integer, Integer> mapSecond = new HashMap<>();
        int maxSecondChoice = robMax(secondChoice, mapSecond, secondChoice.length - 1);
        return Math.max(maxFirstChoice, maxSecondChoice);
    }
    private int robMax(int[] nums, Map<Integer, Integer> map, int index) {
        if (index == 1) {
            return Math.max(nums[0], nums[1]);
        }
        if (index == 0) {
            return nums[0];
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }
        int currentMax = Math.max(robMax(nums, map, index - 1), robMax(nums, map, index - 2) + nums[index]);
        map.put(index, currentMax);
        return currentMax;
    }
}
