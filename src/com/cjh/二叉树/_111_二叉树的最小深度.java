package com.cjh.二叉树;

/**
 * @author 陈哈哈
 * @date 2022年12月23日 22:02
 * @description
 * @Data
 */
public class _111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树的深度
        int left = minDepth(root.left);
        // 计算右子树的深度
        int right = minDepth(root.right);
        // 如果左子树或右子树的深度不为 0，即存在一个子树，那么当前子树的最小深度就是该子树的深度+1
        // 如果左子树和右子树的深度都不为 0，即左右子树都存在，那么当前子树的最小深度就是它们较小值+1
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
