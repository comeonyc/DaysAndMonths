package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/17
 * @description: TODO
 **/
public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    /**
     * 删除倒数第N个节点，关键的思路在于快慢指针，快指针先走n步
     * 核心还是一个数学思维
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head, slow = head, fast = head, pre = null;
        while (n > 0) {
            n--;
            fast = fast.next;
        }

        while (null != fast) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if (null == pre) {
            return slow.next;
        } else {
            pre.next = slow.next;
        }
        return result;
    }
}
