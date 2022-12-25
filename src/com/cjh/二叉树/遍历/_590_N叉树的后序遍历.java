package com.cjh.二叉树.遍历;

import com.cjh.二叉树.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月25日 19:32
 * @description
 * @Data
 */
public class _590_N叉树的后序遍历 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        dfs(root);
        return res;
    }

    public void dfs(Node root) {
        if (root == null) return;
        if (root.children != null) {
            for (Node child : root.children) {
                dfs(child);
            }
        }
        res.add(root.val);
    }
}
