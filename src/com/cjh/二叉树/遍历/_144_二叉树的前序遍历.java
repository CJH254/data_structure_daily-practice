package com.cjh.二叉树.遍历;

import com.cjh.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月20日 20:09
 * @description
 * @Data
 */
public class _144_二叉树的前序遍历 {

    // 递归写法
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }


    // 迭代写法
    List<Integer> resByList = new ArrayList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();

    public List<Integer> preorderTraversalByList(TreeNode root) {
        if (root == null) return new ArrayList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pollLast();
                if (node == null) continue;
                resByList.add(node.val);
                if (node.right != null) {
                    stack.addLast(node.right);
                }
                if (node.left != null) {
                    stack.addLast(node.left);
                }
            }
        }
        return resByList;
    }
}
