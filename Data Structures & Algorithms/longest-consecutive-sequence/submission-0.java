class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for (int num: nums) {
            set.add(num);
        }
        for (int num: set) {
            if (!set.contains(num - 1)) {
                int length = 1;
                while (set.contains(num + 1)) {
                    length++;
                    num++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
