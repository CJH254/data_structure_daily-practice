package com.cjh.二叉树;

/**
 * @author 陈哈哈
 * @date 2022年12月28日 15:17
 * @description
 * @Data
 */
public class _404_左叶子之和 {
    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        dfs(root, false);
        return res;
    }

    // 通过标志位来判断节点是否为左节点
    private void dfs(TreeNode root, boolean isleft) {
        if (root == null) return;
        if (isleft && root.left == null && root.right == null) {
            res += root.val;
        }
        dfs(root.left, true);
        dfs(root.right, false);
    }
}
