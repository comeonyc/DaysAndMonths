package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/25
 * @description: TODO
 **/
public class UniquePaths_62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (0 == i && 0 == j) {
                    continue;
                }
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
