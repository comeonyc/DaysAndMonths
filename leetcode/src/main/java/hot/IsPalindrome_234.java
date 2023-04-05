package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/31
 * @description: TODO
 **/
public class IsPalindrome_234 {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tail = slow.next;
        slow.next = null;
        tail = reverse(tail);

        while(head != null && tail != null){
            if(head.val != tail.val){
                return false;
            }

            head = head.next;
            tail = tail.next;
        }

        return true;
    }

    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
