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
public class _102_二叉树的层序遍历 {
    // 递归写法
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return res;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int level) {
        // 递归写法的妙处就在于，在每一层的第一个左节点开始才会创建该level的队列
        if (res.size() - 1 < level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        // 每次递归调用都用level来确定子节点存放的位置
        if (root.left != null) {
            dfs(root.left, level + 1);
        }
        if (root.right != null) {
            dfs(root.right, level + 1);
        }
    }

    // 迭代写法
    public List<List<Integer>> levelOrderByList(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                level.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
