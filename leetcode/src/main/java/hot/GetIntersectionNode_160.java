package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/25
 * @description: TODO
 **/
public class GetIntersectionNode_160 {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = len(headA);
        int l2 = len(headB);

        int step;
        if (l1 > l2) {
            step = l1 - l2;
            while (step > 0) {
                headA = headA.next;
                step--;
            }
        } else {
            step = l2 - l1;
            while (step > 0) {
                headB = headB.next;
                step--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private static int len(ListNode l) {
        int i = 0;
        while (l != null) {
            i++;
            l = l.next;
        }
        return i;
    }
}
