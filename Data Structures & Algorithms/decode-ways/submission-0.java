class Solution {
    public int numDecodings(String s) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(s, map);
    }
    private int dfs(String s, Map<String, Integer> map) {
        if (s.length() == 0) {
            return 1;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        String oneDigitString = s.substring(0, 1);
        int oneDigitCombination = 0;
        int twoDigitCombination = 0;
        if (Integer.parseInt(oneDigitString) > 0) {
            oneDigitCombination = dfs(s.substring(1), map);
        }
        else {
            oneDigitCombination = 0;
        }
        if (s.length() >= 2) {
            String twoDigitString = s.substring(0, 2);
            if (Integer.parseInt(twoDigitString.substring(0, 1)) != 0 && Integer.parseInt(twoDigitString) > 0 && Integer.parseInt(twoDigitString) <= 26) {
                twoDigitCombination = dfs(s.substring(2), map);
            }
            else {
                twoDigitCombination = 0;
            }
        }
        int acc = oneDigitCombination + twoDigitCombination;
        map.put(s, acc);
        return acc;
    }
}
