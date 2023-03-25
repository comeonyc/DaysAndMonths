package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/16
 * @description: TODO
 **/
public class SortList_148 {
    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        a.next = new ListNode(2);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(3);

        ListNode listNode = sortList(a);

        System.out.println(listNode);

    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(next);
        ListNode tmp = new ListNode(0);
        ListNode cur = tmp;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = new ListNode(left.val);
                left = left.next;
            } else {
                cur.next = new ListNode(right.val);
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return tmp.next;
    }

}
