package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/27
 * @description: TODO
 **/
public class ReverseList_206 {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next;

        while (null != cur) {
            next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
