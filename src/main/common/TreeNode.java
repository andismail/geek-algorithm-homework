package common;

/**
 * 前序：根左右
 * 中序：左根右
 * 后序：左右根
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
