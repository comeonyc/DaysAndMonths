package hot;

/**
 * @author: yc_comeon
 * @date: 2023/4/4
 * @description: TODO
 **/
public class CanPartition_416 {
    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        if (nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        boolean[][] dp = new boolean[len][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == nums[i]) {
                    dp[i][j] = true;
                } else if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][target];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 10, 6}));
    }

}
