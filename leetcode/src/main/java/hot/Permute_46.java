package hot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: yc_comeon
 * @date: 2023/2/21
 * @description: TODO
 **/
public class Permute_46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        find(result, new ArrayList<>(), new HashSet<>(), nums);
        return result;
    }

    private static void find(List<List<Integer>> result, List<Integer> tmp, Set<Integer> used, int[] nums) {
        if (used.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(i)) {
                tmp.add(nums[i]);
                used.add(i);
                find(result, tmp, used, nums);
                tmp.remove(tmp.size() - 1);
                used.remove(i);
            }
        }
    }

}
