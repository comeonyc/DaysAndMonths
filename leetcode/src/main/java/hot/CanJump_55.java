package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/23
 * @description: TODO
 **/
public class CanJump_55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJumpWithDp(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            int step = nums[i];
            for (int j = 0; j <= step; j++) {
                dp[i] = i + j > n || dp[i] || dp[i + j];

                if (dp[i]) break;
            }
        }
        return dp[0];
    }


    /**
     * 如果i比maxRight小，那么一定可以到达i，所以可以更新maxRigh
     */
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxRight = 0;
        for (int i = 0; i < n; i++) {
            if (i <= maxRight) {
                maxRight = Math.max(i + nums[i], maxRight);
            }

            if (maxRight >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
