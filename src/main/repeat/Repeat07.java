package repeat;

public class Repeat07 {

    /*
     * 26.删除排序数组中的重复项
     * 189.旋转数组
     * 21.合并两个有序链表（升序）
     * 88.合并两个有序数组（非递减顺序）
     * 1.两数之和
     * 283.移动零
     * 66.加一
     */

    public int _26(int[] nums) {
        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[q] != nums[p]) {
                if (q - p == 1) {
                    p ++;
                    q ++;
                    continue;
                }

                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public void _189(int[] nums, int k) {
        k = k % nums.length;
        f_189(nums, 0, k - 1);
        f_189(nums, k, nums.length - 1);
        f_189(nums, 0, nums.length - 1);
    }

    private void f_189(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s ++;
            e--;
        }
    }
}
