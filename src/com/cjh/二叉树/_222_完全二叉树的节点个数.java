package com.cjh.二叉树;

/**
 * @author 陈哈哈
 * @date 2022年12月26日 14:44
 * @description
 * @Data
 */
public class _222_完全二叉树的节点个数 {
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        // 左右子树层数相等说明：左子树为完美二叉树，然后再计算剩下右子树的节点个数
        if (left == right) {
            return (1 << left) + countNodes(root.right);
        } else {
            // 左右子树层数不相等说明：右子树为完美二叉树，左子树多出了一部分，然后再计算剩下左子树的节点个数
            return (1 << right) + countNodes(root.left);
        }
    }

    // i层树的节点个数为2^(i)-1,加上原节点：2^(i)-1 + 1 = 2^(i)
    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }
}
