package com.cjh.链表;

/**
 * @author 陈哈哈
 * @date 2022年12月31日 20:09
 * @description
 * @Data
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
