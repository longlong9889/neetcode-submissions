class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        int ans = 0;
        int maxRepeatingCharacter = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            maxRepeatingCharacter = Math.max(maxRepeatingCharacter, map.get(s.charAt(i)));
            while (i - start - maxRepeatingCharacter + 1 > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;   
    }
}
