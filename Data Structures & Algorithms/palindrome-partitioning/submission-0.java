class Solution {
    public List<List<String>> partition(String s) {
        List<String> currentList = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 1) {
            currentList.add(s);
            res.add(new ArrayList<>(currentList));
            return res;
        }
        Map<String, Boolean> map = new HashMap<>();
        helper(s, currentList, res, 0, map);
        return res;
    }
    private boolean isPalindrom(String s) {
        if (s.length() == 1) {
            return true;
        }
        int left = 0; int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private void helper(String s, List<String> currentList, List<List<String>> res, int index, Map<String, Boolean> map) {
        if (index == s.length()) {
            res.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String currentString = s.substring(index, i + 1);
            if (map.containsKey(currentString)) {
                if (map.get(currentString)) {
                    currentList.add(currentString);
                }
                else {
                    continue;
                }
            }
            else {
                if (isPalindrom(currentString)) {
                    currentList.add(currentString);
                    map.put(currentString, true);
                }
                else {
                    map.put(currentString, false);
                    continue;
                }
            }
            helper(s, currentList, res, i + 1, map);
            if (map.get(currentString)) {
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
