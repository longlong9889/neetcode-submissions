class Solution {
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] prerequisite: prerequisites) {
            map.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int course) {
        if (visiting.contains(course)) {
            return false;
        }
        if (map.get(course).isEmpty()) {
            return true;
        }
        visiting.add(course);
        for (int prerequisite: map.get(course)) {
            if (!dfs(prerequisite)) {
                return false;
            }
        }
        visiting.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}
