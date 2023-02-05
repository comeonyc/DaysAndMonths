package hot;

/**
 * @author: yc_comeon
 * @date: 2023/2/5
 * @description: 最长回文子串
 * 1、动态规划  要有想dp方程的思维
 * 2、中心扩散的思维去想 中心想好是一个中心还是两个中心
 **/
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindromeUsingCenterExplore("bb"));
    }

    public static String longestPalindromeUsingDp(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0, max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[j][i] = true;
                } else if (i - j == 1) {
                    dp[j][i] = chars[i] == chars[j];
                } else {
                    dp[j][i] = dp[j + 1][i - 1] && chars[i] == chars[j];
                }

                if (dp[j][i] && i - j + 1 > max) {
                    max = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static String longestPalindromeUsingCenterExplore(String s) {
        if (null == s || s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int max = 0, start = 0;
        for (int i = 0; i < chars.length; i++) {
            int len1 = getMaxLen(chars, i, i);
            int len2 = getMaxLen(chars, i, i + 1);
            if (len1 > max && len1 > len2) {
                max = len1;
                start = i - (len1 - 1) / 2;
            } else if (len2 > max && len2 > len1) {
                max = len2;
                start = i - (len2 - 2) / 2;
            }
        }
        return s.substring(start, start + max);
    }

    public static int getMaxLen(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - 1 - (left + 1) + 1;
    }
}
