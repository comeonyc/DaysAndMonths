package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/17
 * @description: TODO
 **/
public class MergeTwoLists {
    public static void main(String[] args) {


    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode cur = result;

        while (null != list1 && null != list2) {
            int val = -1;
            if (list1.val < list2.val) {
                val = list1.val;
                list1 = list1.next;
            } else {
                val = list2.val;
                list2 = list2.next;
            }
            cur.next = new ListNode(val);
            cur = cur.next;
        }

        if (null != list1) {
            cur.next = list1;
        }

        if (null != list2) {
            cur.next = list2;
        }

        return result.next;
    }
}

