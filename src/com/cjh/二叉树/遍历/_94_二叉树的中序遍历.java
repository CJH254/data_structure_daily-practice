package com.cjh.二叉树.遍历;

import com.cjh.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月20日 20:01
 * @description
 * @Data
 */
public class _94_二叉树的中序遍历 {
    List<Integer> res = new ArrayList<>();

    // 递归写法
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }


    // 迭代写法
    public List<Integer> inorderTraversalByList(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (stack.size() > 0 || root != null) {
            // 1.左节点全部入栈
            if (root != null) {
                stack.addLast(root);
                root = root.left;
            } else {
                // 左节点全部入栈后弹出头结点加到结果集里，在将节点的指针指向右节点
                TreeNode node = stack.pollLast();
                res.add(node.val);
                root = node.right;
            }
        }
        return res;
    }
}
