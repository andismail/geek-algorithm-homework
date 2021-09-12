package week06;

public class LeetCode64 {

    private int minPathSum = Integer.MAX_VALUE;
    private int[][] dirs = {{1, 0}, {0, 1}};

    public int minPathSum(int[][] grid) {
        dfs(grid, 0, 0, grid[0][0]);
        return minPathSum;
    }

    private void dfs(int[][] grid, int row, int col, int sum) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            minPathSum = Math.min(minPathSum, sum);
            return;
        }

        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow < 0 || nextCol < 0
                    || nextRow >= grid.length
                    || nextCol >= grid[0].length) continue;
            sum += grid[nextRow][nextCol];
            dfs(grid, nextRow, nextCol, sum);
            sum -= grid[nextRow][nextCol];
        }
    }
}
