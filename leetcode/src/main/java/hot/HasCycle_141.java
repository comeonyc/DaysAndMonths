package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/4
 * @description: TODO
 **/
public class HasCycle_141 {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (null != fast) {
            fast = fast.next;
            if (null == fast) {
                return false;
            } else {
                fast = fast.next;
            }
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
