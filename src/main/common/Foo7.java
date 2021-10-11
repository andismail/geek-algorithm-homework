package common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 */
public class Foo7 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(common.TreeNode root, int targetSum) {
        Deque<Integer> res = new ArrayDeque<>();
        List<List<Integer>> r = new ArrayList<>();
        foo(root, targetSum, res, r, 0);

        return r;
    }

    private void foo(common.TreeNode root, int target, Deque<Integer> res, List<List<Integer>> r, int cur) {
        cur += root.val;
        if (cur == target) {
            r.add(new ArrayList<>(res));
            return;
        }

        res.add(root.val);
        foo(root.left, target, res, r, cur);
        res.removeLast();
        foo(root.right, target, res, r, cur);
        res.removeLast();
    }

    static class TreeNode {
        int val;
        common.TreeNode left;
        common.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, common.TreeNode left, common.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

