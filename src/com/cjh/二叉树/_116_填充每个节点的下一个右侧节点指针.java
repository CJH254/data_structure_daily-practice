package com.cjh.二叉树;

import java.util.LinkedList;

/**
 * @author 陈哈哈
 * @date 2022年12月23日 14:34
 * @description
 * @Data
 */
public class _116_填充每个节点的下一个右侧节点指针 {
    // 前序遍历的迭代写法
    public Node connect(Node root) {
        if (root == null) return null;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 获取第一个节点作为前置节点，用于连接下一个节点
            Node pre = queue.removeFirst();
            if (pre.left != null) queue.addLast(pre.left);
            if (pre.right != null) queue.addLast(pre.right);
            // 因为已经获取了一个节点，所以得出下一个节点开始算
            for (int i = 1; i < size; i++) {
                Node next = queue.removeFirst();
                if (next.left != null) queue.addLast(next.left);
                if (next.right != null) queue.addLast(next.right);
                pre.next = next;
                pre = next;
            }
        }
        return root;
    }

    // 递归写法
    public Node connectByDfs(Node root) {
        if (root == null) return null;
        dfs(root.left, root.right);
        return root;
    }

    private void dfs(Node node1, Node node2) {
        // 结束条件，任意节点为空都不应该继续连接，否则会出现空指针
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        dfs(node1.left, node1.right);
        dfs(node2.left, node2.right);
        dfs(node1.right, node2.left);
    }

    // 复用dummyNode，减少了出队入队的效率
    public Node connectByDummyNode(Node root) {
        if (root == null)
            return root;
        //cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node();
            //pre表示访下一层节点的前一个节点
            Node pre = dummy;
            //然后开始遍历当前层的链表
            while (cur != null) {
                if (cur.left != null) {
                    //如果当前节点的左子节点不为空，就让pre节点
                    //的next指向他，也就是把它串起来
                    pre.next = cur.left;
                    //然后再更新pre
                    pre = pre.next;
                }
                //同理参照左子树
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }
}
