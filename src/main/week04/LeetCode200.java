package week04;

public class LeetCode200 {

    public int numIslands(char[][] grid) {

    }

    private void dfs(char[][] grid, int r, int c) {
        if (0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length) {
            return;
        }

        if (grid[r][c] != 1) {
            return;
        }

        grid[r][c] = 2;

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
