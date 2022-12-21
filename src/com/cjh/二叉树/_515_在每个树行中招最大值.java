package com.cjh.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月21日 23:33
 * @description
 * @Data
 */
public class _515_在每个树行中招最大值 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 根据节点值的范围可知0肯定不是最小值，所以这里要用int类型的最小值作为比较值
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                max = Math.max(max, node.val);
                if (i == size - 1) res.add(max);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
        return res;
    }
}
