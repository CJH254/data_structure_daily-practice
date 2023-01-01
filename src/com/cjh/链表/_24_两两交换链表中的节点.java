package com.cjh.链表;

/**
 * @author 陈哈哈
 * @date 2023年01月01日 18:04
 * @description
 * @Data
 */
public class _24_两两交换链表中的节点 {
    public ListNode swapPairsByWhile(ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;
        // 判断cur.next和cur.next.next是为了确定有两个可以反转的节点
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // cur指针移动到下一个node1之前的位置,这样才可以获取到node1和node2
            cur = node1;
        }
        return dummyHead.next;
    }

    public ListNode swapPairsByDFS(ListNode head) {
        if (head == null || head.next == null) return head;
        // 保留next节点用于指向head节点
        ListNode newHead = head.next;
        // head节点先指向newHead的next节点
        head.next = swapPairsByDFS(newHead.next);
        // newHead指向自己的前一个节点
        newHead.next = head;
        return newHead;
    }
}
