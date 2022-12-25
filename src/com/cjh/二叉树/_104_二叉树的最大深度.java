package com.cjh.二叉树;

/**
 * @author 陈哈哈
 * @date 2022年12月23日 21:26
 * @description
 * @Data
 */
public class _104_二叉树的最大深度 {
    // 这题如果用二叉树层序遍历的迭代法做的话还是很简单的，只需要控制一个深度的变量，每次累加1即可
    // 用递归的话可能就容易犯一些错误，咱就是说记得每一层递归的返回值记得多加个1
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
