package com.cjh.二叉树.遍历;

import com.cjh.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月21日 22:19
 * @description
 * @Data
 */
public class _107_二叉树的层序遍历II {
    List<List<Integer>> res = new ArrayList<>();

    // 这题其实就是考二叉树的层序遍历，然后再接一个反转即可，二叉树层序遍历的递归写法更值得研究
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        Collections.reverse(res);
        return res;
    }

    private void dfs(TreeNode node, int level) {
        if (res.size() - 1 < level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        if (node.left != null) dfs(node.left, level + 1);
        if (node.right != null) dfs(node.right, level + 1);
    }
}
