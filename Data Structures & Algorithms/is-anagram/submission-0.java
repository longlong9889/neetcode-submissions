class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] stringS = s.toCharArray();
        char[] stringT = t.toCharArray();
        Arrays.sort(stringS);
        Arrays.sort(stringT);
        for (int i = 0; i < s.length(); i++) {
            if (stringS[i] != stringT[i]) {
                return false;
            }
        }
        return true;
    }
}
