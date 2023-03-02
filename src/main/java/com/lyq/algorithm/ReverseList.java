package com.lyq.algorithm;

/**
 * @author yuanqiang.liao
 * @description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @createTime 2023-03-01 17:38:00
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode apple = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode.print(reverseList(apple));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }

        return tail;
    }
}
