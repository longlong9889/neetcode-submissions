class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int col = grid[0].length;
        int row = grid.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    countIsland(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    private void countIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        countIsland(grid, i + 1, j);
        countIsland(grid, i - 1, j);
        countIsland(grid, i, j + 1);
        countIsland(grid, i, j - 1);
    }
}
