package com.cjh.二叉树.遍历;

import com.cjh.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月20日 20:12
 * @description
 * @Data
 */
public class _145_二叉树的后序遍历 {
    // 递归写法

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        res.add(root.val);
    }

    // 迭代写法
    public List<Integer> postorderTraversalByList(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 先放入头结点，最后才会弹出
        stack.addLast(root);
        // 后序遍历为：左右中，那么只需要保证入栈为中右左，最后反转即可
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            res.add(node.val);
            if (node.left != null) {
                stack.addFirst(node.left);
            }
            if (node.right != null) {
                stack.addFirst(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
