package week01;

import common.Node;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class LeetCode21 {

    public static void main(String[] args) {
        //l1 = [1,2,4], l2 = [1,3,4]
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(4);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        Node curr = mergeTwoLists(l1, l2);
        while (curr != null) {
            System.out.print(curr.val + "\t");
            curr = curr.next;
        }

    }

    private static Node mergeTwoLists(Node l1, Node l2) {
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
