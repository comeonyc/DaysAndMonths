package hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yc_comeon
 * @date: 2023/2/19
 * @description: TODO
 **/
public class CombinationSum_39 {
    public static void main(String[] args) {
       quickSort(new int[]{2,1},0,1);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        quickSort(candidates, 0, candidates.length - 1);
        List<List<Integer>> result = new ArrayList<>();
        findV2(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public static void findV2(int[] candidates, int start, int lose, List<Integer> tmp, List<List<Integer>> result) {
        if (lose == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        if (start >= candidates.length || candidates[start] > lose) {
            return;
        }

        //不匹配
        findV2(candidates, start + 1, lose, tmp, result);

        //多次
        tmp.add(candidates[start]);
        findV2(candidates, start, lose - candidates[start], tmp, result);
        tmp.remove(tmp.size() - 1);
    }


    public static void find(int[] candidates, int start, int lose, List<Integer> tmp, List<List<Integer>> result) {
        if (lose == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        if (lose < candidates[start]) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            find(candidates, i,lose - candidates[i], tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int flag = nums[left], start = left, end = right;
        while (left < right) {
            while (left < right && nums[right] >= flag) {
                right--;
            }

            while (left < right && nums[left] <= flag) {
                left++;
            }

            swap(nums, left, right);
        }
        swap(nums, start, left);
        quickSort(nums, left + 1, end);
        quickSort(nums, start, right - 1);
    }

    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
