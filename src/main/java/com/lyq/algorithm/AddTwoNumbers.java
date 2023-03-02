package com.lyq.algorithm;

/**
 * @author yuanqiang.liao
 * @description 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * @createTime 2023-02-28 15:21:00
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode apple = ListNode.buildListNode(new int[]{2, 4, 3});

        ListNode boy = ListNode.buildListNode(new int[]{5, 6, 4});

        ListNode result = addTwoNumbers(apple, boy);
        ListNode.print(result);
    }

    public static ListNode addTwoNumbers(ListNode apple, ListNode boy) {
        if (apple == null) return boy;
        if (boy == null) return apple;

        int oneMore = 0;
        ListNode result = null;
        ListNode current = result;
        while (apple != null || boy != null) {
            int one = apple != null ? apple.val : 0;
            int two = boy != null ? boy.val : 0;

            int sum = one + two + oneMore;
            if (result == null) {
                result = current = new ListNode(sum % 10);
            } else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
            oneMore = sum / 10;

            apple = apple != null ? apple.next : null;
            boy = boy != null ? boy.next : null;
        }
        if (oneMore > 0) {
            current.next = new ListNode(oneMore);
        }
        return result;
    }

}
