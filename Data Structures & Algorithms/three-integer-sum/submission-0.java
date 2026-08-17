class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int target = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            target = 0 - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    List<Integer> accept = new ArrayList<>();
                    accept.add(nums[i]);
                    accept.add(nums[j]);
                    accept.add(map.get(nums[j]));
                    list.add(accept);
                    Collections.sort(accept);
                    set.add(accept);
                }
                map.put(target - nums[j], nums[j]);
            }
            map.clear();
        }
        return new ArrayList<>(set);
    }
}
