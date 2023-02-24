package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/25
 * @description: TODO
 **/
public class ClimbStairs_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
