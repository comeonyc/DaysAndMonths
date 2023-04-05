package hot;

/**
 * @author: yc_comeon
 * @date: 2023/4/5
 * @description: TODO
 **/
public class MaxProfit_309 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[3][n];
        dp[1][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            //不持股，今天没卖出
            //  昨天没持股
            //  昨天持股卖出的
            dp[0][i] = Math.max(dp[0][i - 1], dp[2][i - 1]);
            //今天持股
            //  昨天持股
            //  昨天不持股，今天卖出的
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);
            //不持股，今天卖出
            dp[2][i] = dp[1][i - 1] + prices[i];
        }

        return Math.max(dp[0][n - 1], Math.max(dp[1][n - 1], dp[2][n - 1]));
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
