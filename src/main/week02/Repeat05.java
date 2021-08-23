package week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 242.有效的字母异位词
 * 49.异位词分组
 * 94.二叉树的中序遍历
 * 144.二叉树的前序遍历
 * 589.N叉树的前序遍历
 * 590.N叉树的后序遍历
 * N叉树的层序遍历
 * *40.最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * *239.滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * *347.前K个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class Repeat05 {

    public static int[] _239(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }

            q.addLast(i);

            if (q.peek() + k <= i) {
                q.poll();
            }

            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Set<Integer>> list = new ArrayList<>();
    }
}