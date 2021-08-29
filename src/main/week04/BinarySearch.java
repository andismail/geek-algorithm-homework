package week04;

public class BinarySearch {

    public int foo(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        int mid = 0;
        while (s < e) {
            mid = (s + e) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return mid;
    }
}
