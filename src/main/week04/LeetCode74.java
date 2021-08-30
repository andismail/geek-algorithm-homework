package week04;

public class LeetCode74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int[] nums = new int[matrix.length * matrix[0].length];
        int idx = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nums[idx++] = matrix[i][j];
            }
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }


    public static boolean searchMatrix1(int[][] matrix, int target) {

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j <= matrix[0].length - 1; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
                if (target > matrix[i][j]) {
                    continue;
                }
                if (target < matrix[i][j]) {
                    break;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        searchMatrix1(matrix, 3);
    }
}
