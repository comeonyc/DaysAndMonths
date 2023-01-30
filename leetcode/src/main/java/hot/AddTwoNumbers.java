package hot;

/**
 * @author yc_comeon
 * @date: 2023/1/30
 * @description: TODO
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode();
        ListNode result = cur;
        int add = 0;
        while (null != l1 && null != l2) {
            int sum = l1.val + l2.val + add;
            add = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (null != l1) {
            int sum = l1.val + add;
            add = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            l1 = l1.next;
        }

        while (null != l2) {
            int sum = l2.val + add;
            add = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            l2 = l2.next;
        }

        if (add > 0) {
            cur.next = new ListNode(add);
        }

        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
}
