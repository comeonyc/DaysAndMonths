package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/6
 * @description: TODO
 **/
public class IsMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "a*a"));
    }

    public static boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1];

        /*
         * init
         * 空字符串和一个空模式串匹配是匹配的，其余都是不匹配的
         */
        dp[0][0] = true;

        /*
         * 开始构造dp
         * 空模式串从长度为1开始，所以j从1开始便利
         */
        for (int i = 0; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if ('*' == p.charAt(j - 1)) {
                    if (j > 1 && match(s, p, i - 1, j - 2)) {
                        //匹配零次或多次
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        //匹配不上，默认是零次
                        dp[i][j] = dp[i][j - 2];
                    }
                } else if (match(s, p, i-1, j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[sl][pl];
    }

    public static boolean match(String s, String p, int i, int j) {
        if (i < 0) {
            return false;
        }

        return s.charAt(i) == p.charAt(j) || '.' == p.charAt(j);
    }
}
