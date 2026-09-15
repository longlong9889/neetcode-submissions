class Solution {
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] prerequesite: prerequisites) {
            map.get(prerequesite[0]).add(prerequesite[1]);
        }
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course)) {
                return new int[]{};
            }
        }
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
    private boolean dfs(int course) {
        if (visiting.contains(course)) {
            return false;
        }
        if (map.get(course).isEmpty()) {
            if (!res.contains(course)) {
                res.add(course);
            }
            return true;
        }
        visiting.add(course);
        for (int prerequisite: map.get(course)) {
            if (!dfs(prerequisite)) {
                return false;
            }
        }
        res.add(course);
        visiting.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}
