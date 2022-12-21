package com.cjh.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月21日 23:14
 * @description
 * @Data
 */
public class _637_二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            // 节点的范围为-2^31 <= Node.val <= 2^31 - 1,所以累加值要用long，否则相加会越界
            for (int i = 0; i < size; i++) {
                // 切记：只有让每一层的节点都弹出，才可以把他们的子节点加入队列中
                TreeNode node = queue.removeFirst();
                sum += node.val;
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                if (i == size - 1) {
                    res.add(sum / (size * 1.0));
                }
            }
        }
        return res;
    }
}
