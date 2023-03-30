package hot;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: yc_comeon
 * @date: 2023/3/30
 * @description: TODO
 **/
public class FindTargetSumWays_494 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        return (int) find(nums, 0).stream().filter(x -> target == x).count();
    }

    public static List<Integer> find(int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> result = new ArrayList<>(1);
            result.add(nums[index]);
            result.add(nums[index] * (-1));
            return result;
        }

        List<Integer> result = new ArrayList<>();
        find(nums, index + 1).forEach(x -> {
            result.add(x + nums[index]);
            result.add(x - nums[index]);
        });
        return result;
    }

}
