package week04;

public class LeetCode200 {

    public int numIslands(char[][] grid) {
        int width = grid.length;
        int height = grid[0].length;

        int cnt = 0;
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                if (grid[w][h] != 1) {
                    continue;
                }
                bfs(w, h, grid);
                cnt++;
            }
        }
        return cnt;
    }

    private void bfs(int w, int h, char[][] grid) {
        if (w - 1 >= 0) {
            char c = grid[w - 1][h];
            if (c == 1) {
                grid[w - 1][h] = 2;
            }
        }
        if (w + 1 < grid.length) {
            char c = grid[w + 1][h];
            if (c == 1) {
                grid[w + 1][h] = 2;
            }
        }
        if (h - 1 >= 0) {
            char c = grid[w][h - 1];
            if (c == 1) {
                grid[w][h - 1] = 2;
            }
        }
        if (h + 1 < grid[0].length) {
            char c = grid[w][h + 1];
            if (c == 1) {
                grid[w][h + 1] = 2;
            }
        }
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

    private void up(char[][] grid, int r, int c) {

    }
}
