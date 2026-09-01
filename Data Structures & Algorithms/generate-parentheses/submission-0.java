class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder current = new StringBuilder();
        List<String> res = new ArrayList<>();
        helper(n, 0, 0, 0, current, res);
        return res;
    }
    private void helper(int n, int index, int open, int close, StringBuilder currentList, List<String> res) {
        if (index == n * 2) {
            res.add(new String(currentList));
            return;
        }
        if (open < n) {
            currentList.append("(");
            helper(n, index + 1, open + 1, close, currentList, res);
            currentList.deleteCharAt(currentList.length() - 1);
        }
        if (close < open) {
            currentList.append(")");
            helper(n, index + 1, open, close + 1, currentList, res);
            currentList.deleteCharAt(currentList.length() - 1);
        }
    }
}
