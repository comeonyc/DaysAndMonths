package hot;

/**
 * @author: yc_comeon
 * @date: 2023/4/5
 * @description: TODO
 **/
public class CountBits_338 {
    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int high = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                high = i;
            }
            dp[i] = dp[i - high] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {

    }
}
