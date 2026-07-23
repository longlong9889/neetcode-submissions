class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int longest = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(i));
            longest = Math.max(longest, set.size());
        }
        return longest;
    }
}
