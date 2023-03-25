package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/8
 * @description: TODO
 **/
public class DetectCycle_142 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);

        System.out.println(detectCycle(listNode));
    }

    /**
     * 核心思想 slow比fast小2倍
     * 2*(a+b) = a + 2*b +c ==> a=c  所以当相遇后从头出发的指针和slow指针一起走即可
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (null != fast) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            } else {
                fast = fast.next;
            }

            if (fast == slow) {
                break;
            }
        }

        if (null == slow) {
            return null;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
