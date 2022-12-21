package com.cjh.二叉树.遍历;

import com.cjh.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月21日 23:01
 * @description
 * @Data
 */
public class _199_二叉树的右视图 {
    // 这题也是考二叉树的层序遍历，找到每一层的最后一个节点进行记录即可
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.addLast(root);
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.removeFirst();
                if (i == size - 1) res.add(node.val);
                if (node.left != null) list.addLast(node.left);
                if (node.right != null) list.addLast(node.right);
            }
        }
        return res;
    }
}
