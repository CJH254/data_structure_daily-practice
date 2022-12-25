package com.cjh.二叉树.遍历;

import com.cjh.二叉树.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月25日 19:31
 * @description
 * @Data
 */
public class _589_N叉树的前序遍历 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<>();
        dfs(root);
        return res;
    }

    public void dfs(Node root) {
        if (root == null) return;
        res.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                dfs(child);
            }
        }
    }
}
