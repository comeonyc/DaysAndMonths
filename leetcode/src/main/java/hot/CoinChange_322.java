package hot;

import java.util.Arrays;

/**
 * @author: yc_comeon
 * @date: 2023/4/5
 * @description: TODO
 **/
public class CoinChange_322 {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = max;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    min = Math.min(dp[i - coin] + 1, min);
                }
            }
            dp[i] = min;
        }

        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
