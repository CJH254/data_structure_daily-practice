package com.cjh.二叉树;

/**
 * @author 陈哈哈
 * @date 2022年12月26日 13:49
 * @description
 * @Data
 */
public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode node1, TreeNode node2) {
        // 其余非法的条件都不满足，那证明到最后节点为空时是合法的
        if (node1 == null && node2 == null) return true;
        // 左右有一个节点为null即为非对称树
        if (node1 == null || node2 == null) return false;
        // 对称的条件还必须得两个节点的值对称
        if (node1.val != node2.val) return false;
        // 对称除了比较兄弟节点外还需要判断内侧和外侧节点是否对称
        return dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }
}
