package com.cjh.二叉树;

/**
 * @author 陈哈哈
 * @date 2022年12月20日 20:02
 * @description
 * @Data
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
