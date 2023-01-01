package com.cjh.链表;

/**
 * @author 陈哈哈
 * @date 2023年01月01日 17:36
 * @description
 * @Data
 */
public class _206_反转链表 {
    public ListNode reverseListByFor(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseListByDFS(ListNode head) {
        // 递归的基本结束条件就得加上当前head为空的情况，避免数据源就是空
        if (head == null || head.next == null) {
            return head;
        }
        // 能找到最后一个节点了
        ListNode lastNode = reverseListByDFS(head.next);
        // 通过当前节点层控制下个节点的next指向
        head.next.next = head;
        head.next = null;
        // 返回反转后的头结点
        return lastNode;
    }
}
