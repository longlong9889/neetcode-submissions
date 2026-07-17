class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 1) {
            List<String> s = new ArrayList<>();
            s.add(strs[0]);
            ans.add(s);
            return ans;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] currentString = s.toCharArray();
            Arrays.sort(currentString);
            String newString = new String(currentString);
            if (!map.containsKey(newString)) {
                map.put(newString, new ArrayList<String>());
            }
            map.get(newString).add(s);
        }
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
