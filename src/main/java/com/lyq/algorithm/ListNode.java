package com.lyq.algorithm;

/**
 * @author yuanqiang.liao
 * @description TODO
 * @createTime 2023-03-01 17:36:00
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


    public static void print(ListNode result) {
        while (result != null) {
            System.out.print(result.val);
            System.out.print(",");
            result = result.next;
        }
    }

    public static ListNode buildListNode(int[] list) {
        ListNode result = new ListNode(list[0]);
        ListNode current = result;
        for (int i = 1; i < list.length; i++) {
            current.next = new ListNode(list[i]);
            current = current.next;
        }
        return result;
    }
}
