package hot;

/**
 * @author: yc_comeon
 * @date: 2023/3/4
 * @description: TODO
 **/
public class NumTrees_96 {
    public static void main(String[] args) {
        System.out.println(numTrees(1));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int cur = 0;
            for (int j = 1; j <= i; j++) {
                cur += dp[j - 1] * dp[i - j];
            }
            dp[i] = cur;
        }

        return dp[n];
    }
}
