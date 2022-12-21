package com.cjh.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月21日 23:22
 * @description
 * @Data
 */
public class _429_N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.removeFirst();
                levelList.add(node.val);
                // N叉树只需要把所有子节点加入队列即可
                if (node.children != null) {
                    for (Node child : node.children) {
                        queue.addLast((child));
                    }
                }
            }
            res.add(levelList);
        }
        return res;
    }
}
