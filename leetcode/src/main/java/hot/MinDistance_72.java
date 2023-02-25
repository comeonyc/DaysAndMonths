package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/25
 * @description: TODO
 **/
public class MinDistance_72 {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int a = dp[i - 1][j] + 1;
                int b = dp[i][j - 1] + 1;
                int c = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    c += 1;
                }
                dp[i][j] = Math.min(Math.min(a, b), c);
            }
        }
        return dp[m][n];
    }
}
