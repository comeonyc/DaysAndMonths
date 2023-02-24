package hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yc_comeon
 * @date: 2023/2/24
 * @description: TODO
 **/
public class Merge_56 {
    public static void main(String[] args) {
        int[][] merge = merge(new int[][]{{1, 4}, {0, 4}});

        System.out.println();
    }

    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        quickSort(intervals, 0, length - 1);
        int index = 0;
        List<List<Integer>> lists = new ArrayList<>();
        while (index < length) {
            int max = intervals[index][1];
            int start = index;
            while (index + 1 < length && max >= intervals[index + 1][0]) {
                max = Math.max(max, intervals[index + 1][1]);
                index++;
            }
            List<Integer> cur = new ArrayList<>();
            cur.add(intervals[start][0]);
            cur.add(max);
            lists.add(cur);

            index++;
        }

        int[][] result = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            result[i][0] = lists.get(i).get(0);
            result[i][1] = lists.get(i).get(1);
        }
        return result;
    }

    public static void quickSort(int[][] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int[] flag = nums[start];
        int left = start, right = end;
        while (left < right) {
            while (left < right && nums[right][0] >= flag[0]) {
                right--;
            }
            while (left < right && nums[left][0] <= flag[0]) {
                left++;
            }

            int[] tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
        }
        nums[start] = nums[left];
        nums[left] = flag;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }


}
