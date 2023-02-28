package hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yc_comeon
 * @date: 2023/2/25
 * @description: TODO
 **/
public class Subsets_78 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, 0, result, new ArrayList<>());

        return result;
    }

    public static List<List<Integer>> subsets(int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<>();

        if (index == nums.length) {
            List<Integer> empty = new ArrayList<>();
            result.add(empty);
            return result;
        }

        List<List<Integer>> next = subsets(nums, index + 1);
        int cur = nums[index];
        result.addAll(next);
        if (next.isEmpty()) {
            List<Integer> a = new ArrayList<>();
            a.add(cur);
            result.add(a);
            return result;
        }
        next.forEach(x -> {
            List<Integer> a = new ArrayList<>();
            a.add(cur);
            a.addAll(x);
            result.add(a);
        });
        return result;
    }

    public static void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> tmp) {
        if (index == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(nums[index]);
        dfs(nums, index + 1, result, tmp);
        tmp.remove(tmp.size() - 1);
        dfs(nums, index + 1, result, tmp);
    }
}
