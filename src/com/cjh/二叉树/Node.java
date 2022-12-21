package com.cjh.二叉树;

import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月20日 20:02
 * @description
 * @Data
 */
public class Node {
    public int val;
    public List<Node> children;

    Node() {
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
