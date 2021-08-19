package week01;

import common.ListNode;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class LeetCode21 {

    public static void main(String[] args) {
        //l1 = [1,2,4], l2 = [1,3,4]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode curr = mergeTwoLists(l1, l2);
        while (curr != null) {
            System.out.print(curr.val + "\t");
            curr = curr.next;
        }

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }

        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }

}
