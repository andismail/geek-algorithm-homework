package common;

public class Foo5 {

    public static ListNode foo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = foo(l1.next, l2);
            return l1;
        }
        l2.next = foo(l1, l2.next);
        return l2;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);

        ListNode n2 = new ListNode(4);
        n2.next = new ListNode(5);
        n2.next.next = new ListNode(6);

        ListNode res = foo(n1, n2);

    }
}
