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

    /**
     * 最小~最大
     * dp 关心数组第二维是什么
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays(int[] nums, int target) {
        int max = 0, min = 0;
        for (int i : nums) {
            if (i > 0) {
                max += i;
                min -= i;
            } else {
                max -= i;
                min += i;
            }
        }

        int len = nums.length;
        int[][] dp = new int[len][max - min + 1];
        dp[0][nums[0] - min] += 1;
        dp[0][-nums[0] - min] += 1;

        if (target > max || target < min) {
            return 0;
        }
        for (int i = 1; i < len; i++) {
            for (int j = min; j <= max; j++) {
                if (dp[i - 1][j - min] > 0) {
                    dp[i][j - min + nums[i]] += dp[i - 1][j - min];
                    dp[i][j - min - nums[i]] += dp[i - 1][j - min];
                }
            }
        }

        return dp[len - 1][target - min];
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
