package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: yc_comeon
 * @date: 2023/2/18
 * @description: TODO
 **/
public class MergeKLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode tmp = result;
        int flag = 0, min = Integer.MAX_VALUE, minIndex = 0;

        while (true) {
            for (int i = 0; i < lists.length; i++) {
                if (null == lists[i]) {
                    flag++;
                    continue;
                }
                if (lists[i].val < min) {
                    minIndex = i;
                    min = lists[i].val;
                }
            }

            if (flag == lists.length) {
                break;
            }

            tmp.next = new ListNode(min);
            tmp = tmp.next;
            min = Integer.MAX_VALUE;
            lists[minIndex] = lists[minIndex].next;
            flag = 0;
        }
        return result.next;
    }


    public static ListNode mergeKListsV2(ListNode[] lists) {

        if (null == lists || lists.length == 0) {
            return null;
        }

        List<ListNode> listNodeList = Arrays.stream(lists).collect(Collectors.toList());

        while (listNodeList.size() > 1) {
            int index = 0;
            List<ListNode> merge = new ArrayList<>(listNodeList.size() / 2 + 1);
            while (index < listNodeList.size()) {
                merge.add(merge2List(
                        index < listNodeList.size() ? listNodeList.get(index) : null,
                        index + 1 < listNodeList.size() ? listNodeList.get(index + 1) : null));
                index += 2;
            }
            listNodeList = merge;
        }

        return listNodeList.get(0);

    }

    public static ListNode merge2List(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode tmp = result;

        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tmp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tmp = tmp.next;
        }

        if (null != l1) {
            tmp.next = l1;
        }

        if (null != l2) {
            tmp.next = l2;
        }

        return result.next;
    }
}
