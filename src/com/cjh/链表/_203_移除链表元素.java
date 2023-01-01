package com.cjh.链表;

/**
 * @author 陈哈哈
 * @date 2022年12月31日 20:09
 * @description
 * @Data
 */
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(-1, head);
        ListNode cur = node;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                // 找到要删除的元素后不能直接将节点跳转到要删除的元素上，因为可能下一个元素也是目标元素
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return node.next;
    }
}
