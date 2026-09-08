class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        StringBuilder currentString = new StringBuilder();
        helper(digits, map, 0, currentString, res);
        return res;
    }
    private void helper(String digits, Map<Integer, String> map, int i, StringBuilder currentString, List<String> res) {
        if (i == digits.length()) {
            res.add(new String(currentString));
            return;
        }
        int digit = digits.charAt(i) - '0';
        String set = map.get(digit);
        for (int j = 0; j < set.length(); j++) {
            currentString.append(set.charAt(j));
            helper(digits, map, i + 1, currentString, res);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }
}
