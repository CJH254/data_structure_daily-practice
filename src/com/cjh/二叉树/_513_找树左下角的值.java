package com.cjh.二叉树;

import java.util.LinkedList;

/**
 * @author 陈哈哈
 * @date 2022年12月28日 15:46
 * @description
 * @Data
 */
public class _513_找树左下角的值 {
    public int findBottomLeftValueByQueue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int maxLeftSideVal = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                // 直接记录下每层最左边的第一个
                if (i == 0) {
                    maxLeftSideVal = node.val;
                }
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
        return maxLeftSideVal;
    }

    // 深度
    int DEEP = -1;
    // 最左边的值
    int mostMaxAtLeftSide = 0;

    public int findBottomLeftValueDFS(TreeNode root) {
        if (root == null) return mostMaxAtLeftSide;
        dfs(root, 0);
        return mostMaxAtLeftSide;
    }

    private void dfs(TreeNode root, int deep) {
        if (root == null) return;
        // 到了叶子结点，需要记录最左边的值以及比较最大的深度
        // 确保了同层进来的第一个左节点是叶子结点
        if (root.left == null && root.right == null) {
            if (deep > DEEP) {
                mostMaxAtLeftSide = root.val;
                DEEP = deep;
            }
        }
        // 先用左节点进行递归，确保同层的第一个节点就是左节点
        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
    }
}
