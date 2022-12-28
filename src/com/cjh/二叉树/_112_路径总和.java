package com.cjh.二叉树;

/**
 * @author 陈哈哈
 * @date 2022年12月28日 16:55
 * @description
 * @Data
 */
public class _112_路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        // targetSum == root.val证明该路径已经到了最后一个节点了
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
