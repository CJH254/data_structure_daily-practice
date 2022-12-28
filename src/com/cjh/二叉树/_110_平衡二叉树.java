package com.cjh.二叉树;

/**
 * @author 陈哈哈
 * @date 2022年12月28日 15:28
 * @description
 * @Data
 */
public class _110_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        //根节点左右子树高度差符合条件，左子树和右子树也都分别符合条件
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //计算子树的最大高度
    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}
