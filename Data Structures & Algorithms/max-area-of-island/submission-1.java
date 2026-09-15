class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int m = 0; m < row; m++) {
            for (int n = 0; n < col; n++) {
                if (grid[m][n] == 1) {
                    int currentArea = calculateArea(grid, m, n);
                    max = Math.max(max, currentArea);
                }
            }
        }
        return max;
    }
    private int calculateArea(int[][] grid, int m, int n) {
        if (m < 0 || m >= grid.length || n < 0 || n >= grid[0].length || grid[m][n] == 0) {
            return 0;
        }
        grid[m][n] = 0;
        return calculateArea(grid, m + 1, n) 
            +  calculateArea(grid, m - 1, n)
            +  calculateArea(grid, m, n + 1)
            +  calculateArea(grid, m, n - 1)
            +  1;
    }
}
